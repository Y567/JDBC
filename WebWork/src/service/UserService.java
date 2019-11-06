package service;

import domain.User;

import java.util.List;

public interface UserService {
    /**
     * 用户信息操作
     */
    /*
    实现用户信息的查询
     */
    public List<User> findAll();
}
