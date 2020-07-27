package com.xjw.sell.repository;

import com.xjw.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * 2020/7/23 10:59
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderMasterRepositoryTest {

    private final String OPENID = "aaaaaa";

    @Autowired
    private OrderMasterRepository repository;

    @Test
    void findByBuyerOpenid() {
        PageRequest pageRequest = PageRequest.of(0, 15);
        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, pageRequest);
        Assert.assertNotEquals(0, result.getTotalElements());
    }

    @Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("000001");
        orderMaster.setBuyerAddress("英国-布里斯托尔");
        orderMaster.setBuyerName("tony");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setBuyerPhone("17601599031");
        orderMaster.setOrderAmount(new BigDecimal(6.88));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

}