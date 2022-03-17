package jspCase.dao;

import jspCase.domain.User;

import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-03-17-14:59
 * @Function Description ：
 * 用户操作的dao
 */

public interface UserDao {
    public List<User> findAll();
}
