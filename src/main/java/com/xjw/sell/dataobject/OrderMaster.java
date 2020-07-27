package com.xjw.sell.dataobject;

import com.xjw.sell.enums.OrderStatusEnum;
import com.xjw.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Transient;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 2020/7/23 10:40
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    // 支付状态
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    // 创建时间
    private Date createTime;

    // 更新时间
    private Date updateTime;

    /*@Transient //不对应数据库
    private List<OrderDetail> orderDetailList;*/

}
