package codewater.mybatisplus;

import codewater.mybatisplus.enums.SexEnum;
import codewater.mybatisplus.mapper.UserMapper;
import codewater.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ： CodeWater
 * @create ：2022-06-01-22:28
 * @Function Description ：测试枚举类型
 */
@SpringBootTest
public class MybatisPlusEnumTest {
    
    @Autowired
    private UserMapper userMapper;
    
    @Test
    public void test(){
        User user = new User();
        user.setName( "admin" );
        user.setAge( 20 );
        user.setSex( SexEnum.FEMALE );
        int result = userMapper.insert( user );
        System.out.println( result );
    }
    
}
