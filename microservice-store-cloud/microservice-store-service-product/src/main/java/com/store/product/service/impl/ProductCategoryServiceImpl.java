package com.store.product.service.impl;

import com.store.model.ProductCategory;
import com.store.product.biz.ProductCategoryBiz;
import com.store.product.service.IProductCategoryService;
import com.store.vo.TableData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Api(value = "API - ProductServiceImpl", description = "内容操作")
@RestController
@Slf4j
public class ProductCategoryServiceImpl implements IProductCategoryService {

    @Autowired
    private ProductCategoryBiz productCategoryBiz;

	@Override
	public TableData<ProductCategory> findByPage(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
		//查询列表数据
		return productCategoryBiz.findByPage(page, pageSize);
	}
}
