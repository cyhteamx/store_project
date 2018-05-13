package com.store.controller;

import com.store.model.ProductCategory;
import com.store.product.service.IProductCategoryService;
import com.store.utils.ResultVOUtil;
import com.store.vo.ResultVO;
import com.store.vo.TableData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ProductCategoryController {

    @Autowired
    private IProductCategoryService productCategoryService;

    @GetMapping("/category/list")
    public ResultVO<TableData<ProductCategory>> findByPage(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        TableData<ProductCategory> item = productCategoryService.findByPage(page, pageSize);
        return ResultVOUtil.success(item);
    }

}
