package com.xjw.sell.exception;

import com.xjw.sell.enums.ResultEnum;

/**
 * 2020/7/23 14:13
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
