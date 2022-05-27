package jedis.example.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jedis.example.dao.ProvinceDao;
import jedis.example.dao.impl.ProvinceDaoImpl;
import jedis.example.domain.Province;
import jedis.example.service.ProvinceService;
import jedis.util.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-04-30-21:30
 * @Function Description ：
 */
public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJson() {
        //1.先从redis中查询数据
        //1.1获取redis客户端连接
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");

        //2判断 province_json 数据是否为null(第一次查询redis没有，后面在查询就会存进redis中，从这里查询)
        if (province_json == null || province_json.length() == 0) {
            System.out.println("redis中没有数据， 查询数据库。。。。。");
            List<Province> ps = dao.findAll();
            //2.2将list序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(ps);

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
//            json数据放入redis
            jedis.set("province", province_json);
            jedis.close();
        } else {
            System.out.println("redis中有数据，查询缓存。。。。");
        }
        return province_json;
    }

}
