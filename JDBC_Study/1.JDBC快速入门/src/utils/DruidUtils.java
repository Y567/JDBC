package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtils {
    private static DataSource ds;
    static{
        //1.导入jar包
        //2.定义配置文件并加载
        Properties properties = new Properties();
        try {
            properties.load(DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //3.获取池子
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //获取连接对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }


    //释放资源
    public static void close(ResultSet rs,Statement stmt, Connection con){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement stmt, Connection con){
        close(null,stmt,con);
    }

    //返回数据库连接池对象
    public static DataSource getDataSource(){
        return ds;
    }
}
