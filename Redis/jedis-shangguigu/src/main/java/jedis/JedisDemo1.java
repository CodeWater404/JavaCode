package jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * @author ： CodeWater
 * @create ：2022-05-27-21:09
 * @Function Description ：redis配置文件中要设置允许远程连接，并且服务器的防火墙也要开启
 */
public class JedisDemo1 {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("ip", 6379);
        //测试连接
        String value = jedis.ping();
        System.out.println(value);
        jedis.close();
    }

    //key string 
    @Test
    public void demo1() {
        Jedis jedis = new Jedis("ip", 6379);
        jedis.set("name", "lucy");

        String name = jedis.get("name");
        System.out.println(name);

        //设置多个key-value
        jedis.mset("k1", "v1", "k2", "v2");
        List<String> mget = jedis.mget("k1", "k2");
        System.out.println(mget);

        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }

        jedis.close();
    }

    //list
    @Test
    public void demo2() {
        Jedis jedis = new Jedis("ip", 6379);

        jedis.lpush("key1", "lucy", "mary", "jack");
        List<String> values = jedis.lrange("key1", 0, -1);
        System.out.println(values);
        jedis.close();
    }

    //set
    @Test
    public void demo3() {
        Jedis jedis = new Jedis("ip", 6379);

        jedis.sadd("names", "lucy");
        jedis.sadd("names", "mary");

        Set<String> names = jedis.smembers("names");
        System.out.println(names);
        jedis.close();
    }

    //hash
    @Test
    public void demo4() {
        Jedis jedis = new Jedis("ip", 6379);

        jedis.hset("users", "age", "20");
        String hget = jedis.hget("users", "age");
        System.out.println(hget);
        jedis.close();
    }

    //zset
    @Test
    public void demo5() {
        Jedis jedis = new Jedis("ip", 6379);

        jedis.zadd("china", 100d, "shanghai");

        Set<String> china = jedis.zrange("china", 0, -1);
        System.out.println(china);
        
        jedis.close();
    }

}
