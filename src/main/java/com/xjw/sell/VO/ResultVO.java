package com.xjw.sell.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * http请求返回的最外层对象
 * 2020/7/22 17:05
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> {

    // 错误码
    private Integer code;

    // 提示信息
    private String msg;

    // 返回的具体内容
    private T data;

}
