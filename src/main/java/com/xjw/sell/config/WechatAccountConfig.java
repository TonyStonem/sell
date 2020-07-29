package com.xjw.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 2020/7/28 17:40
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private String appId;

    private String appSecret;

}
