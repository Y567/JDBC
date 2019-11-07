package service;

import domain.User;

import java.util.List;

public interface UserService {
    /**
     * 玩家信息操作
     */
    /*
    实现玩家信息的查询
     */
    List<User> findAll();

    /*
    实现玩家添加功能
     */
    void addUser(User user);

    /*
    根据id删除玩家
     */
    void deleteUserById(int id);

    /*
    根据id查询玩家，并封装为User对象
     */
    User findUserById(int id);
}
