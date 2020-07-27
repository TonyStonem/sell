package com.xjw.sell.repository;

import com.xjw.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 2020/7/22 11:08
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
