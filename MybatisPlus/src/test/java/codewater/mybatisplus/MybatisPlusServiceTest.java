package codewater.mybatisplus;

import codewater.mybatisplus.pojo.User;
import codewater.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-06-01-15:26
 * @Function Description ：
 */
@SpringBootTest
public class MybatisPlusServiceTest {
    @Autowired
    private UserService userService;
    
    @Test
    public void testGetCount(){
        //SELECT COUNT( * ) FROM user
        long count = userService.count( );
        System.out.println( count );
    }
    
    @Test
    public void testInsertMore(){
        List<User> list = new ArrayList<>();
        for( int i = 1 ; i <= 10 ; i++ ){
            User user = new User();
            user.setName("tom" + i );
            user.setAge( 20 + i );
            list.add( user );
        }
        //批量添加： 多个INSERT INTO user ( id, name, age ) VALUES ( ?, ?, ? )
        boolean result = userService.saveBatch( list );
        System.out.println( result );
        
    }
}
