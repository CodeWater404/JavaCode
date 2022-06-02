package codewater.mybatisplus.service.impl;

import codewater.mybatisplus.entity.User;
import codewater.mybatisplus.mapper.UserMapper;
import codewater.mybatisplus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author codewater
 * @since 2022-06-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
