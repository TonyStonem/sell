package com.xjw.sell.dto;

import lombok.Data;

/**
 * 2020/7/23 14:37
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
@Data
public class CartDTO {

    private String productId;

    private Integer productQuantity;

    public CartDTO(){}

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
