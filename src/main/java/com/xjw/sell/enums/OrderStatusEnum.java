package com.xjw.sell.enums;

import lombok.Getter;

/**
 * 2020/7/23 10:46
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
@Getter
public enum  OrderStatusEnum {

    NEW(0,"新下单"),
    FINISH(1,"完结"),
    CANCEL(2,"已取消"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
