package demo6.service;

import demo6.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ： CodeWater
 * @create ：2022-04-06-21:04
 * @Function Description ：
 * -1超时就是不设置，如果设置了超时没有提交，那么就会回滚；
 * 7种传播行为；4种格力级别
 * 
 */
@Service
@Transactional(readOnly = false,timeout = -1 ,propagation = Propagation.REQUIRED ,isolation = Isolation.REPEATABLE_READ )//加在类上就是所有的方法都有事务
public class UserService {
    @Autowired
    private UserDao userDao;
    
    public void accountMoney(){
        userDao.reduceMoney();
//        int i = 10/0;
        userDao.addMoney();
    }
}
