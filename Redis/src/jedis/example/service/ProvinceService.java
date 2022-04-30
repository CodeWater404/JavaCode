package jedis.example.service;

import jedis.example.domain.Province;

import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-04-30-21:29
 * @Function Description ：
 */
public interface ProvinceService {
    public List<Province> findAll();
    public String findAllJson();
}
