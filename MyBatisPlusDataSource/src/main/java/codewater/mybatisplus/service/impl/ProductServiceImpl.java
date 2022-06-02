package codewater.mybatisplus.service.impl;

import codewater.mybatisplus.mapper.ProductMapper;
import codewater.mybatisplus.pojo.Product;
import codewater.mybatisplus.service.ProductService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author ： CodeWater
 * @create ：2022-06-01-23:27
 * @Function Description ：
 */
@Service
@DS( "slave_1" )  //也可以加到方法上！！！
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    
}
