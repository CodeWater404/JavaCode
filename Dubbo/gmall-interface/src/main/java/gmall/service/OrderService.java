package gmall.service;

import gmall.bean.UserAddress;

import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-06-12-16:01
 * @Function Description ：
 */
public interface OrderService {

    /**
     * 初始化订单
     * @param userId
     */
    public List<UserAddress> initOrder(String userId );
}
