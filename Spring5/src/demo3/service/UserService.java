package demo3.service;

import demo3.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ： CodeWater
 * @create ：2022-04-05-19:27
 * @Function Description ：
 */
@Component(value = "userService")
public class UserService {
    @Value(value = "abc")//对属性赋值
    private String name;
//    @Autowired
//    @Qualifier( value="userDaoImpl1" )
//    private UserDao userDao;

    //    @Resource//根据类型
    @Resource(name = "userDaoImpl1") //根据名称
    private UserDao userDao;

    public void add() {
        System.out.println("service add ...." + name);
        userDao.add();
    }
}
