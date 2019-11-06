package druid;

import utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo2 {
    /*
    利用工具类完成一条插入操作
     */
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        //1.获取连接对象
        try {
            conn = DruidUtils.getConnection();
            //2.写sql语句
            String sql = "insert into account values(null,?,?)";
            //3.获取执行sql语句的对象
            pstmt = conn.prepareStatement(sql);
            //设置值
            pstmt.setString(1,"啊啊狗");
            pstmt.setInt(2,10000);
            //执行语句
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //最后释放资源
            DruidUtils.close(pstmt,conn);
        }
    }
}
