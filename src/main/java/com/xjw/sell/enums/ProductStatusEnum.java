package com.xjw.sell.enums;

import lombok.Getter;

/**
 * 商品状态
 * 2020/7/22 16:40
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
@Getter
public enum ProductStatusEnum {

    UP(0, "在线"),
    DOWN(1, "下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
