package com.store.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

//import org.hibernate.annotations.DynamicUpdate;
//import javax.persistence.Entity;

//@Entity
@Data
@Table(name = "tb_product_category")
public class ProductCategory {

    /** 类目id. */
    @Id
//    @GeneratedValue
    @Column(name = "category_id")
    private Integer categoryId;

    /** 类目名字. */
    @Column(name = "category_name")
    private String categoryName;

    /** 类目编号. */
    @Column(name = "category_type")
    private Integer categoryType;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }


}
