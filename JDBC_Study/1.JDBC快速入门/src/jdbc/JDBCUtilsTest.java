package jdbc;

import information.Info;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtilsTest {
    /**
     * 需求，将查询的整张表的数据封装在一个集合中，一个对象封装一行的数据
     * @return
     */
    public static void main(String[] args) {
        List<Info> all = new JDBCUtilsTest().findAll();
        System.out.println(all);
        System.out.println(all.size());
    }
    public List<Info> findAll(){
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Info> list = new ArrayList<>();
        //注册驱动
        try {
            //获取数据库连接对象
            con = JDBCUtils.getConnection();
            //写sql语句
            String sql = "select * from student";
            //获取sql执行对象
            stmt = con.createStatement();
            //执行sql语句
            rs = stmt.executeQuery(sql);
            //遍历结果集
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                list.add(new Info(id,name,age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,con);
        }
        return list;
    }
}
