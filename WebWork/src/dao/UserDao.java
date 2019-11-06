package dao;

import domain.Administrator;
import domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 实现数据库操作的Dao层
     */
    //查询玩家的信息
    public List<User> findAll();
}
