package com.xjw.sell.controller;

import com.xjw.sell.VO.ProductInfoVO;
import com.xjw.sell.VO.ProductVO;
import com.xjw.sell.VO.ResultVO;
import com.xjw.sell.dataobject.ProductCategory;
import com.xjw.sell.dataobject.ProductInfo;
import com.xjw.sell.service.ProductCategoryService;
import com.xjw.sell.service.ProductInfoService;
import com.xjw.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2020/7/22 17:03
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
        List<ProductVO> productVOList = new ArrayList<>();

        //1. 查询所有的上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        if (productInfoList != null && productInfoList.size() > 0) {

            //2. 查询类目（一次性查询）
            List<Integer> categoryTypeList =
                    productInfoList.stream().map(it -> it.getCategoryType()).collect(Collectors.toList());
            if (categoryTypeList != null && categoryTypeList.size() > 0) {
                List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

                //3. 数据拼装
                if (categoryList != null && categoryList.size() > 0) {
                    for (ProductCategory category : categoryList) {
                        ProductVO productVO = new ProductVO();
                        productVO.setCategoryName(category.getCategoryName());
                        productVO.setCategoryType(category.getCategoryType());

                        List<ProductInfoVO> productInfoVOList = new ArrayList<>();
                        for (ProductInfo productInfo : productInfoList) {
                            if (productInfo.getCategoryType().equals(category.getCategoryType())) {
                                ProductInfoVO productInfoVO = new ProductInfoVO();
                                BeanUtils.copyProperties(productInfo, productInfoVO);
                                productInfoVOList.add(productInfoVO);
                            }
                        }
                        productVO.setProductInfoVOList(productInfoVOList);
                        productVOList.add(productVO);
                    }
                }
            }
        }
        return ResultVOUtil.success(productVOList);
    }

}
