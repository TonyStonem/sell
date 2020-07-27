package com.xjw.sell.repository;

import com.xjw.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 2020/7/23 11:32
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void testSave() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("000000");
        orderDetail.setOrderId("000000");
        orderDetail.setProductId("000000");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(3.66));
        orderDetail.setProductQuantity(1);
        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    void findByOrOrderId() {
        List<OrderDetail> result = repository.findByOrOrderId("000000");
        Assert.assertNotEquals(0, result.size());
    }
}