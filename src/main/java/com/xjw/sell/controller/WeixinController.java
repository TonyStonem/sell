package com.xjw.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试controller
 * 2020/7/28 11:10
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public String auth(@RequestParam("code") String code) {
        log.info("wechat auth >> code={}", code);
        return code;
    }

}
