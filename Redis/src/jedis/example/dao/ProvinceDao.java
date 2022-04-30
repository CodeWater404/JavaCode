package jedis.example.dao;

import jedis.example.domain.Province;

import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-04-30-21:28
 * @Function Description ：
 */
public interface ProvinceDao {
    public List<Province> findAll();
}
