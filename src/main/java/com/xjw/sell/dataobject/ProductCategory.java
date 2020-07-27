package com.xjw.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 2020/7/22 11:03
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
//@Table(name = "product_category")
@Entity //映射数据库
@Data
@DynamicUpdate //动态更新
public class ProductCategory {

    /**
     * 类目id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /**
     * 类目名字.
     */
    private String categoryName;

    /**
     * 类目编号.
     */
    private Integer categoryType;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryId=" + categoryId +
                ",categoryName=" + categoryName +
                ",categoryType=" + categoryType +
                "}";
    }
}
