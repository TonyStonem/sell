package com.xjw.sell;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 2020/7/22 10:31
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
//@Data
public class LoggerTest {

    @Test
    public void test1() {
        String name = "tony";
        String age = "17";

        log.debug("debug >>");
        log.info("info >>");
        log.info("name:{}, age:{}", name, age);
        log.error("error >>");
    }

}
