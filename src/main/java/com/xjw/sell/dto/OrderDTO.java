package com.xjw.sell.dto;

import com.xjw.sell.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 2020/7/23 14:03
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
@Data
public class OrderDTO {

    private String orderId;

    // 买家姓名
    private String buyerName;

    // 买家联系方式
    private String buyerPhone;

    // 买家地址
    private String buyerAddress;

    // 买家微信Openid
    private String buyerOpenid;

    // 订单金额
    private BigDecimal orderAmount;

    // 订单状态，默认0 新下单
    private Integer orderStatus;

    // 支付状态
    private Integer payStatus;

    // 创建时间
    private Date createTime;

    // 更新时间
    private Date updateTime;

    private List<OrderDetail> orderDetailList;

}
