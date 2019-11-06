package dao.impl;

import com.alibaba.druid.support.ibatis.DruidDataSourceFactory;
import dao.UserDao;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.DruidUtils;
import utils.JDBCUtils;

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

}
