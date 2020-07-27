package com.xjw.sell.repository;

import com.xjw.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 2020/7/22 11:09
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void testFindOne() {
        Optional<ProductCategory> result = repository.findById(1);
        if (result.isPresent()) {
            ProductCategory productCategory = result.get();
            System.out.println(productCategory.toString());
        }
    }

    @Test
    @Transactional //
    public void testSave() {
        ProductCategory productCategory = new ProductCategory("女生最爱", 13);
        ProductCategory result = repository.save(productCategory);
        org.junit.Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> categoryTypeList = Arrays.asList(2, 3, 4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(categoryTypeList);
        Assert.assertNotEquals(0, result.size());
    }

}