package com.xjw.sell.service.impl;

import com.xjw.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 2020/7/22 16:08
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryServiceImpl service;

    @Test
    void findOne() {
        ProductCategory result = service.findOne(1);
        Assert.assertEquals(new Integer(1), result.getCategoryId());
    }

    @Test
    void findAll() {
        List<ProductCategory> result = service.findAll();
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    void findByCategoryTypeIn() {
        List<Integer> categoryTypeList = Arrays.asList(2, 3, 4);
        List<ProductCategory> result = service.findByCategoryTypeIn(categoryTypeList);
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    void save() {
        ProductCategory productCategory = new ProductCategory("测试", 99);
        ProductCategory result = service.save(productCategory);
        Assert.assertNotNull(result);
    }
}