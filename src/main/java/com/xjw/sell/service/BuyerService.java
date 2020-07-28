package com.xjw.sell.service;

import com.xjw.sell.dto.OrderDTO;

/**
 * 买家
 * 2020/7/28 10:14
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
public interface BuyerService {

    /**
     * 查询一个订单
     */
    OrderDTO findOrderOne(String openid, String orderId);

    /**
     * 取消订单
     */
    OrderDTO cancelOrder(String openid, String orderId);

}
