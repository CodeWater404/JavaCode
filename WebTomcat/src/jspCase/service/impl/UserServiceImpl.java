package jspCase.service.impl;

import jspCase.dao.impl.UserDaoImpl;
import jspCase.domain.User;
import jspCase.service.UserService;
import jspCase.dao.UserDao;

import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-03-17-14:49
 * @Function Description ：
 */

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    
    public List<User> findAll(){
        //调用dao完成查询
        return dao.findAll();
    }
}
