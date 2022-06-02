package codewater.mybatisplus;

import codewater.mybatisplus.mapper.UserMapper;
import codewater.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author ： CodeWater
 * @create ：2022-06-01-8:09
 * @Function Description ：
 */
@SpringBootTest
public class MybatisPlusTest {
    
    @Autowired
    //这里虽然爆红，但是可以运行。在userMapper上加上@Repository注解就不会爆红了
    private UserMapper userMapper; 

    /**
     * 查询一个集合
     */
    @Test
    public void testSelectList(){
        //需要传一个条件构造器，如果没有条件那就是查询所有
        List<User> list = userMapper.selectList( null ); 
        //System.out::println   函数式编程。双冒号就是应用对应的方法
        list.forEach( System.out::println );
    }

    /**
     * 测试添加的方法:INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
     */
    @Test
    public void testInsert(){
        User user = new User();
        user.setName( "da" );
        user.setAge( 100 );
        user.setEmail( "dsajkf@code.com" );
        int result = userMapper.insert( user );
        System.out.println( "result:" + result );
    }

    /**
     * 测试删除方法：id用long类型是因为，数据库中储存的是bigint
     */
    @Test
    public void testDelete(){
        //id: DELETE FROM user WHERE id=?
//        int result = userMapper.deleteById( 1531798228055420930L );
//        System.out.println( "result: " + result );
        
        //键对应的是列名，值对应的是具体的条件，map: DELETE FROM user WHERE name = ? AND age = ?
//        Map<String , Object> map = new HashMap<>();
//        map.put("name" , "张三" );
//        map.put( "age" , "80" );
//        int result = userMapper.deleteByMap( map );
//        System.out.println( "result:" + result );
        
        //批量删除。 list： DELETE FROM user WHERE id IN ( ? , ? , ? )
        List<Long> list = Arrays.asList( 1L , 2L , 3L );
        int result = userMapper.deleteBatchIds( list );
        System.out.println( result );
        
    }

    /**
     * 修改
     */
    @Test
    public void testUpdate(){
        //UPDATE user SET name=?, email=? WHERE id=?
        User user = new User();
        user.setId( 4L );
        user.setName( "克里斯" );
        user.setEmail( "rehwjktgf@code.com" );
        int result = userMapper.updateById( user );
        System.out.println( "result: " + result );
    }

    /**
     * 查询
     */
    @Test
    public void testSelect(){
        //单查：SELECT id,name,age,email FROM user WHERE id=?
//        User user = userMapper.selectById( 1L );
//        System.out.println( user.toString() );
        
        //多个查寻--list：SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
//        List<Long> list = Arrays.asList( 1L , 2L , 3L );
//        List<User> users = userMapper.selectBatchIds( list );
//        users.forEach( System.out::println );
        
        //多个查寻--map：SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
//        Map<String , Object> map = new HashMap<>();
//        map.put("name"  , "Tom" );
//        map.put("age" , 28 );
//        List<User> list = userMapper.selectByMap( map );
//        list.forEach( System.out::println );
        
        //根据条件查询,null:SELECT id,name,age,email FROM user
//        List<User> list = userMapper.selectList( null );
//        list.forEach( System.out::println );
        
        //使用自己写的查询方法
        Map<String , Object> map = userMapper.selectMapById( 1L );
        System.out.println( map );
        
    }

}
