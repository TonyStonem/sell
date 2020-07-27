package com.xjw.sell.repository;

import com.xjw.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 2020/7/22 16:26
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer status);

}
