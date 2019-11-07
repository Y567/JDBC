package dao;

import domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 实现数据库操作的Dao层
     */
    //查询玩家的信息
    List<User> findAll();

    //添加玩家信息
    void addUser(User user);

    //删除玩家信息
    void deleteUserById(int id);

    //根据id查询玩家并返回一个User对象
    User findUserById(int id);
}
