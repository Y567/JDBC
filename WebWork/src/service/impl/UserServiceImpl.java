package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    //一个dao业务操作类对象（实现了玩家信息的查询）
    private UserDao dao = new UserDaoImpl();
    //调用Dao层的方法返回用户信息
    @Override
    public List<User> findAll() {
        return dao.findAll();
    }
}
