package com.xjw.sell.controller;

import com.xjw.sell.VO.ResultVO;
import com.xjw.sell.converter.OrderForm2OrderDTOConverter;
import com.xjw.sell.dataobject.OrderDetail;
import com.xjw.sell.dto.OrderDTO;
import com.xjw.sell.enums.ResultEnum;
import com.xjw.sell.exception.SellException;
import com.xjw.sell.form.OrderForm;
import com.xjw.sell.service.OrderService;
import com.xjw.sell.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2020/7/27 10:45
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确，orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("orderId", createResult.getOrderId());
        return ResultVOUtil.success(resultMap);
    }

    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "15") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid不能为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, PageRequest.of(page, size));
        return ResultVOUtil.success(orderDTOPage.getContent());
    }

    //订单详情

    //取消订单

}
