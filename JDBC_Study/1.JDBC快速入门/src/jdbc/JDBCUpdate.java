package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUpdate {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        //注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //写sql语句
            String sql = "update student set name = '阿狗狗' where id=2";
            String sql2 = "insert into student values(4,'王柏川',22)";
            //设置数据库连接对象
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "gyy");
            //获取执行sql语句的对象
            stmt = con.createStatement();
            //执行语句
            int i = stmt.executeUpdate(sql2);
            System.out.println(i);
            if(i > 0){
                System.out.println("成功执行");
            }else{
                System.out.println("失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            if(con != null){
                try {
                    con.close();
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
        }
    }
}
