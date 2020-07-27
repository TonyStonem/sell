package com.xjw.sell.service.impl;

import com.xjw.sell.dataobject.ProductInfo;
import com.xjw.sell.dto.CartDTO;
import com.xjw.sell.enums.ProductStatusEnum;
import com.xjw.sell.enums.ResultEnum;
import com.xjw.sell.exception.SellException;
import com.xjw.sell.repository.ProductInfoRepository;
import com.xjw.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 2020/7/22 16:37
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        Optional<ProductInfo> result = repository.findById(productId);
        return result.orElse(null);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> result = repository.findById(cartDTO.getProductId());
            if (!result.isPresent()) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = result.get();
            Integer resultStock = productInfo.getProductStock() + 1;
            productInfo.setProductStock(resultStock);
            repository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        // 优化：超卖（卖出去的比库存多），Redis 锁
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> result = repository.findById(cartDTO.getProductId());
            if (!result.isPresent()) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = result.get();
            Integer resultStock = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (resultStock < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(resultStock);

            repository.save(productInfo);
        }
    }

}
