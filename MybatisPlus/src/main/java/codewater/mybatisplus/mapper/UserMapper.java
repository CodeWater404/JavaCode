package codewater.mybatisplus.mapper;

import codewater.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author ： CodeWater
 * @create ：2022-06-01-0:52
 * @Function Description ：
 */
@Repository //将类或接口标志为持久层组件
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据id查询用户信息为map集合
     * @param id
     * @return
     */
    Map<String , Object> selectMapById( Long id );

    /**
     * 通过年龄查询用户信息并分页    分页功能
     * @param page 第一个参数必须是page对象！mybatisplus提供的分页插件
     * @param age
     * @return 返回值也必须是page对象
     */
    Page<User> selectPageVo(@Param("page") Page<User> page , @Param("age") Integer age );
}
