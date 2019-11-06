package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdelete {
    /*
    jdbc完成数据库表的记录删除
     */
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        //注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "gyy");
            //获取执行sql语句的对象
            statement = connection.createStatement();
            //sql语句
            String sql = "delete from student where id = 2";
            //执行语句
            int i = statement.executeUpdate(sql);
            System.out.println(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
