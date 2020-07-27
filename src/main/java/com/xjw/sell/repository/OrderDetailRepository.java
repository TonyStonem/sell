package com.xjw.sell.repository;

import com.xjw.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 2020/7/23 10:54
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrOrderId(String orderId);

}
