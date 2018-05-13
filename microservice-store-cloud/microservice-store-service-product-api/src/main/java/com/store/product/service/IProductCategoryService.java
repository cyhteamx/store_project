package com.store.product.service;


import com.store.model.ProductCategory;
import com.store.product.service.hystrix.ProductCategoryServiceHystrix;
import com.store.vo.TableData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="microservice-store-service-product", fallback = ProductCategoryServiceHystrix.class)
public interface IProductCategoryService {

    @RequestMapping(value = "/product/category/list", method = RequestMethod.GET)
    TableData<ProductCategory> findByPage(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize);

}
