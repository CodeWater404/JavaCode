package demo6.test;

import demo6.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author ： CodeWater
 * @create ：2022-04-07-17:00
 * @Function Description ：
 * junit5
 */
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:/demo6/bean1.xml")
    
//    复合注解
@SpringJUnitConfig(locations = "classpath:/demo6/bean1.xml")
public class JTest5 {
    
    @Autowired
    private UserService userService;
    
    @Test 
    public void test1(){
        userService.accountMoney();
    }
}
