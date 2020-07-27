package com.xjw.sell.enums;

import lombok.Getter;

/**
 * 2020/7/23 10:46
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
@Getter
public enum PayStatusEnum {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
