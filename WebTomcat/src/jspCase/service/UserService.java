package jspCase.service;

import jspCase.domain.User;

import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-03-17-14:49
 * @Function Description ：
 * service层：业务逻辑层，处理视图web和dao数据访问层，在他们之间
 */
/*用户管理业务的接口*/
public interface UserService {
    /*查询所有的用户信息*/
    public List<User> findAll();
}
