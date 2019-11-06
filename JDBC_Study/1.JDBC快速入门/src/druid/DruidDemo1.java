package druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        Properties properties = new Properties();
        InputStream is = DruidDemo1.class.getResourceAsStream("../druid.properties");
        System.out.println("成功找到"+is);
        properties.load(is);
        //4.获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);
        //5.获取连接对象
        Connection conn = ds.getConnection();
        //6.写SQL语句
        String sql = "update account set balance = balance - ? where id = ?";
        //7.获取执行sql语句的对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,500);
        pstmt.setInt(2,2);
        //8.执行
        pstmt.executeUpdate();
        //9.释放资源（conn对象是归还给连接池）
        pstmt.close();
        conn.close();
    }
}
