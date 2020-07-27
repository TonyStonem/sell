package com.xjw.sell.utils;

import java.util.Random;

/**
 * 2020/7/23 14:26
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式：时间+随机数
     *
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }

}
