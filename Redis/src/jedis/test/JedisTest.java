package jedis.test;

import jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ： CodeWater
 * @create ：2022-04-30-18:38
 * @Function Description ：Jedis的测试类
 */

public class JedisTest {
    @Test
    public void test1(){
//        获取连接
        Jedis jedis = new Jedis("localhost" , 6379 );
//        操作
        jedis.set("username" , "lisi" );
//        关闭连接
        jedis.close();
    }
    
//    string操作
    @Test
    public void test2(){
        Jedis jedis = new Jedis();
        jedis.set("user" , "wangwu" );
        String user = jedis.get("user");
        System.out.println( user );

        //可以使用setex()方法存储可以指定过期时间的 key value
        //将activecode：jaja键值对存入redis，并且10秒后自动删除该键值对
        jedis.setex("activecode" , 10 , "jaja" );
        
        jedis.close();
    }
    
//    hash
    @Test
    public void test3(){
        Jedis jedis = new Jedis();
//        save  键名别跟上面的重复了
        jedis.hset("us" , "name" , "lisi" );
        jedis.hset( "us" , "age" , "25" );
        jedis.hset( "us" , "gender" , "male" );
//        hget
        String name = jedis.hget("us" , "name" );
        System.out.print("获取单个值=============================");
        System.out.println( name );
        
//        获取所有数据
        Map<String , String> user = jedis.hgetAll("us");
        
//        keyset
        Set<String> keySet = user.keySet();
        System.out.print("获取所有的数据（先拿到键的集合方式）=============");
        for( String key : keySet ){
//            get value
            String value = user.get( key );
            System.out.println( key + " : " + value );
        }
        jedis.close();
    }
    
//    list操作
    @Test
    public void test4(){
        Jedis jedis = new Jedis();
        jedis.lpush("mylist" , "a" , "b" , "c" );
        jedis.rpush( "mylist" , "a" , "b" , "c" );

        List<String> mylist = jedis.lrange( "mylist" , 0  , -1 );
        System.out.print("输出所有===========");
        System.out.println( mylist );

//        pop
        String elements1 = jedis.lpop( "mylist" );
        System.out.println( elements1 );
        String element2 = jedis.rpop( "mylist" );
        System.out.println( element2 );
                
//        list范围获取
        List<String> mylist2 = jedis.lrange( "mylist" , 0 , -1 );
        System.out.println( mylist2 );
        
        jedis.close();
    }
    
//    set
    @Test
    public void test5(){
        Jedis jedis = new Jedis();
//        第一个键  后面几个是值，一次存储多个
        jedis.sadd( "myset" , "java" , "php" , "c++" );
        Set<String> myset = jedis.smembers("myset");
        System.out.println( myset );
        
        jedis.close();
    }
    
//    sortedset
    @Test
    public void test6(){
        Jedis jedis = new Jedis();
        jedis.zadd("mysortedset" , 5 , "亚瑟" );
        jedis.zadd( "mysortedset" , 20 , "后裔" );
        jedis.zadd( "mysortedset" , 10 , "孙悟空" );
        
        Set<String> mysortedset = jedis.zrange( "mysortedset" ,  0, -1 );
        System.out.println( mysortedset );
        
        jedis.close();
    }
    
//    测试连接池
    @Test
    public void test7(){
//        配置
        JedisPoolConfig config = new JedisPoolConfig();
//        最大连接数
        config.setMaxTotal( 50 );
//        最大空闲数
        config.setMaxIdle( 10 );
        JedisPool jedisPool = new JedisPool();
        Jedis jedis = jedisPool.getResource();
        jedis.set( "haha" , "hahahhah" );
        
        jedis.close();
        
    }
    
//    jedis连接池工具类的使用
    @Test
    public void test8(){
        Jedis jedis = JedisPoolUtils.getJedis();
        
        jedis.set( "hello" , "word" );
        
        jedis.close();
    }
}
