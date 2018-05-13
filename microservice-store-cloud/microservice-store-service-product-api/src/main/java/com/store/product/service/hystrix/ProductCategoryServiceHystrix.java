package com.store.product.service.hystrix;

import com.store.model.ProductCategory;
import com.store.product.service.IProductCategoryService;
import com.store.vo.TableData;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 产品分类服务 熔断处理
 *
 */

@Component
public class ProductCategoryServiceHystrix implements IProductCategoryService {

    @Override
    public TableData<ProductCategory> findByPage(int page, int pageSize) {
        return null;
    }
}
