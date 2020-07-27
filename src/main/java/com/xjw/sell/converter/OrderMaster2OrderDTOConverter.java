package com.xjw.sell.converter;

import com.xjw.sell.dataobject.OrderMaster;
import com.xjw.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 2020/7/27 9:45
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(it ->
                convert(it)).collect(Collectors.toList());
    }

}
