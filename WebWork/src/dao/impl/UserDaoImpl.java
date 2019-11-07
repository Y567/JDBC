package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.DruidUtils;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
    //利用JDBCTemplate实现数据库操作
    @Override
    public List<User> findAll() {
        //1.定义sql语句
        String sql = "select * from user";
        //2.执行语句
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public void addUser(User user) {
        //定义sql语句
        String sql = "insert into user values(null,?,?,?,?,?)";
        //执行sql并返回
        template.update(sql,user.getUsername(),user.getPassword(),user.getTell(),user.getGender(),user.getBirthday());
    }

    @Override
    public void deleteUserById(int id) {
        //定义SQL语句
        String sql = "delete from user where id = ?";
        //执行语句
        template.update(sql,id);
    }

    @Override
    public User findUserById(int id) {
        //定义sql语句
        String sql = "select * from user where id=?";
        //执行
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),id);
    }
}
