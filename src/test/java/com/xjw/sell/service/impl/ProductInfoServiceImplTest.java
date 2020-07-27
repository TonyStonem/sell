package com.xjw.sell.service.impl;

import com.xjw.sell.dataobject.ProductInfo;
import com.xjw.sell.dto.CartDTO;
import com.xjw.sell.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 2020/7/22 16:43
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl service;

    @Test
    void findOne() {
        ProductInfo result = service.findOne("000000");
        Assert.assertNotNull(result);
    }

    @Test
    void findUpAll() {
        List<ProductInfo> result = service.findUpAll();
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    void findAll() {
        PageRequest pageRequest = PageRequest.of(0, 15);
        Page<ProductInfo> result = service.findAll(pageRequest);
        Assert.assertNotEquals(0, result.getTotalElements());
    }

    @Test
    void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("111111");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(6.66));
        productInfo.setProductStock(99);
        productInfo.setProductDescription("皮皮虾描述：好吃的皮皮虾");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);

        ProductInfo result = service.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    void decreaseStock() {
        List<CartDTO> cartDTOList = new ArrayList<>();
        CartDTO cartDTO = new CartDTO("000000", 1);
        cartDTOList.add(cartDTO);
        service.decreaseStock(cartDTOList);
    }

}