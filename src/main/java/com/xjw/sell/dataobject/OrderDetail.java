package com.xjw.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 2020/7/23 10:40
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
@Entity
@Data
@DynamicUpdate
public class OrderDetail {

    @Id
    private String detailId;

    // 订单ID
    private String orderId;

    // 商品ID
    private String productId;

    // 商品名称
    private String productName;

    // 商品单价
    private BigDecimal productPrice;

    // 商品数量
    private Integer productQuantity;

    // 商品小图
    private String productIcon;

    // 创建时间
    private Date createTime;

    // 更新时间
    private Date updateTime;

}
