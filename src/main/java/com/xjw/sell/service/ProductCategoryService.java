package com.xjw.sell.service;

import com.xjw.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * 2020/7/22 16:01
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
public interface ProductCategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
