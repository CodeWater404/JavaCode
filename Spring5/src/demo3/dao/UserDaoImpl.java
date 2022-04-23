package demo3.dao;

import org.springframework.stereotype.Repository;

/**
 * @author ： CodeWater
 * @create ：2022-04-05-19:55
 * @Function Description ：
 */
@Repository(value = "userDaoImpl1")
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao add...");

    }
}
