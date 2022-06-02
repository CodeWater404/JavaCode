package codewater.mybatisplus.service.impl;

import codewater.mybatisplus.mapper.UserMapper;
import codewater.mybatisplus.pojo.User;
import codewater.mybatisplus.service.UserService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author ： CodeWater
 * @create ：2022-06-01-23:23
 * @Function Description ：
 */
@Service
@DS("master")  //设置数据源
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    
}
