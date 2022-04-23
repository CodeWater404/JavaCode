package demo1.service;

import demo1.dao.UserDao;

/**
 * @author ： CodeWater
 * @create ：2022-04-04-20:58
 * @Function Description ：演示外部bean
 */
public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add() {
        System.out.println("service add.............");
        userDao.update();
    }
}
