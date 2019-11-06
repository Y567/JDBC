package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc {
    /*
    演示jdbc整体连接步骤
     */
    public static void main(String[] args) throws Exception {
        //1.导入jar包
        //2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库连接对象
        Connection connection = DriverManager.getConnection("jdbc.jdbc:mysql://localhost:3306/db2", "root", "gyy");
        //4.写sql语句(注意这里面的sql语句不加分号结束)
        String sql = "update student set age=22 where id=2";
        //5.创建sql语句执行对象
        Statement statement = connection.createStatement();
        //6.执行sql语句
        int i = statement.executeUpdate(sql);
        System.out.println(i);

        //7.释放资源
        connection.close();
        statement.close();
    }
}
