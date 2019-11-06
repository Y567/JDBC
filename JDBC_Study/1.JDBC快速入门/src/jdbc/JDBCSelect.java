package jdbc;

import java.sql.*;

public class JDBCSelect {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet ret = null;
        //注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //写sql语句
            String sql = "select * from student";
            //设置数据库连接对象
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "gyy");
            //获取执行sql语句的对象
            stmt = con.createStatement();
            //执行语句
            ret = stmt.executeQuery(sql);
            while(ret.next()){
                int i = ret.getInt("id");
                String name = ret.getString("name");
                int age = ret.getInt("age");
                System.out.println(i+"&"+name+"&"+age);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            if(ret != null){
                try {
                    ret.close();
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
