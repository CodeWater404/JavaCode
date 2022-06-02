package codewater.mybatisplus;

import codewater.mybatisplus.mapper.UserMapper;
import codewater.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author ： CodeWater
 * @create ：2022-06-01-18:12
 * @Function Description ：
 */
@SpringBootTest
public class MyBatisPlusWrapperTest {
    
    @Autowired
    private UserMapper userMapper;

    /**
     * 组装条件查询
     */
    @Test
    public void test01(){
        //查询用户名包含a，年龄在20到30之间，邮箱信息不为null的用户信息
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user 
        // WHERE is_deleted=0 AND (user_name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like( "name" , "a")
                .between( "age" , 20 , 30 )
                .isNotNull( "email");
        List<User> list = userMapper.selectList( queryWrapper );
        list.forEach( System.out::println );
    }

    /**
     * 组装排序查询
     */
    @Test
    public void test02(){
        //查询用户信息，按照年龄的降序排序，若年龄相同，则按照id升序排序
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user 
        // WHERE is_deleted=0 ORDER BY age DESC,uid ASC
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc( "age" )
                .orderByAsc( "id" );
        List<User> list = userMapper.selectList( queryWrapper );
        list.forEach( System.out::println );
        
    }

    /**
     * 组件条件进行删除
     */
    @Test
    public void test03(){
        //删除邮箱地址为null的用户信息
        //UPDATE t_user SET is_deleted=1 WHERE is_deleted=0 AND (email IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull( "email" );
        int result = userMapper.delete( queryWrapper );
        System.out.println( result );
                
    }

    /**
     * 组件条件进行修改
     */
    @Test
    public void test04(){
        //将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
        //UPDATE t_user SET user_name=?, email=? WHERE is_deleted=0 
        // AND (age > ? AND user_name LIKE ? OR email IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt( "age" , 20)
                .like( "name" , "a" )
                .or()
                .isNull( "email" );
        User user = new User();
        user.setName("小明");
        user.setEmail( "test@code.com" );
        int result = userMapper.update( user , queryWrapper );
        System.out.println( result );
        
    }

    /**
     * 组装条件进行修改，有优先级
     */
    @Test
    public void test05(){
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        //lambda中的条件优先执行
        //UPDATE t_user SET user_name=?, email=? WHERE is_deleted=0 
        // AND (user_name LIKE ? AND (age > ? OR email IS NULL))
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name" , "a" )
                .and( i -> i.gt( "age" , 20 ).or()
                .isNull( "email" ) );  //里面是lambda表达式，i相当于还是一个queryWrapper
        User user = new User();
        user.setName("小红");
        user.setEmail( "test1@code.com" );
        int result = userMapper.update( user , queryWrapper );
        System.out.println( result );
        
    }

    /**
     * 查询指定的字段
     * 
     */
    @Test
    public void test06(){
        //查询用户的用户名、年龄、邮箱信息
        //SELECT user_name,age,email FROM t_user WHERE is_deleted=0
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select( "name" , "age" , "email" );
        List<Map<String , Object>> list = userMapper.selectMaps( queryWrapper ); 
        list.forEach( System.out::println );
        
    }

    /**
     * 组装子查询
     */
    @Test
    public void test07(){
        //查询id小于等于100的用户信息
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user 
        // WHERE is_deleted=0 AND (uid IN (select uid from t_user where uid <= 100))
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql( "id" , "select id from t_user where id <= 100 " );
        List<User> list = userMapper.selectList( queryWrapper );
        list.forEach( System.out::println );
        
    }

    /**
     * 使用updateWrapper进行修改;使用updateWrapper不需要指明实体类型了
     */
    @Test
    public void test08(){
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like( "name" , "a")
                .and( i -> i.gt( "age" , 20 ).or()
                .isNull( "email" ) );
        updateWrapper.set( "name" , "小黑" ).set( "email" ,"da@code.com" );
        int result = userMapper.update( null , updateWrapper );
        System.out.println( result );
        
    }

    /**
     * 拼接变量到sql中, 动态组装
     */
    @Test
    public void test09(){
        String username = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //引入的是baomidou的.   不为空字符串，不为null ， 不为空白符
        if( StringUtils.isNotBlank(username) ){
            queryWrapper.like( "name" , username );
        }
        if( ageBegin != null ){  // gt大于  ge大于等于
            queryWrapper.ge( "age" , ageBegin );
        }
        if( ageEnd != null ){
            queryWrapper.le( "age" , ageEnd );
        }
        //SELECT id,name,age,email,is_deteled FROM t_user WHERE is_deteled=0 AND (age >= ? AND age <= ?)
        List<User> list = userMapper.selectList( queryWrapper );
        list.forEach( System.out::println );
        
    }

    /**
     * 对上面写法的优化
     */
    @Test
    public void test10(){
        String username = "a";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //SELECT id,name,age,email,is_deteled FROM t_user WHERE is_deteled=0 AND (name LIKE ? AND age <= ?)
        queryWrapper.like( StringUtils.isNotBlank( username ) , "name" , username )
                .ge( ageBegin != null , "age" , ageBegin )
                .le( ageEnd != null , "age" , ageEnd );
        List<User> list = userMapper.selectList( queryWrapper );
        list.forEach( System.out::println );
        
    }

    /**
     * 使用lambdaQueryWrapper对于上面代码的重写
     */
    @Test
    public void test11(){
        String username = "a";
        Integer ageBegin = 20 ;
        Integer ageEnd = 30;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //ELECT id,name,age,email,is_deteled FROM t_user WHERE is_deteled=0 
        // AND (name LIKE ? AND age >= ? AND age <= ?)
        queryWrapper.like( StringUtils.isNotBlank(username) , User::getName , username )
                .ge( ageBegin != null , User::getAge , ageBegin )
                .le( ageEnd != null , User::getAge , ageEnd );
        List<User> list = userMapper.selectList( queryWrapper );
        list.forEach( System.out::println );
        
    }

    /**
     * 使用lambdaUpdateQueryWrapper 对于上面的进行重写
     */
    @Test
    public void test12(){
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        // UPDATE t_user SET name=?,email=? WHERE is_deteled=0 AND (name LIKE ? AND (age >= ? OR email IS NULL))
        updateWrapper.like( User::getName , "a" )
                .and( i -> i.ge( User::getAge , 20 ).or().isNull( User::getEmail ) );
        updateWrapper.set( User::getName , "小黑" ).set( User::getEmail , "1234@code.com" );
        int result = userMapper.update( null , updateWrapper );
        System.out.println( result );
    }


}
