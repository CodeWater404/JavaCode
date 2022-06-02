package codewater.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import codewater.pojo.User;
import codewater.service.UserService;
import codewater.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




