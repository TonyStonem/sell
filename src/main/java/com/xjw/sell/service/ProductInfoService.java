package com.xjw.sell.service;

import com.xjw.sell.dataobject.ProductInfo;
import com.xjw.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 2020/7/22 16:35
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
public interface ProductInfoService {

    ProductInfo findOne(String productId);

    /**
     * 查询在线商品
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

}
