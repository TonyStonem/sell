package com.xjw.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 2020/7/22 16:15
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    @Id
    private String productId;

    // 姓名
    private String productName;

    // 单价
    private BigDecimal productPrice;

    // 库存
    private Integer productStock;

    // 小图
    private String productIcon;

    // 描述
    private String productDescription;

    // 状态 0:正常 1:下架
    private Integer productStatus;

    // 类目编号
    private Integer categoryType;

}
