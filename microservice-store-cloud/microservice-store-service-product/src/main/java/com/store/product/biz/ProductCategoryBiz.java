package com.store.product.biz;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.store.biz.BaseBiz;
import com.store.mapper.IProductCategoryMapper;
import com.store.model.ProductCategory;
import com.store.vo.TableData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductCategoryBiz extends BaseBiz<IProductCategoryMapper,ProductCategory> {

    public TableData<ProductCategory> findByPage(int page, int pageSize) {
        Page<ProductCategory> result = PageHelper.startPage(page, pageSize);
        super.selectListAll();
        return new TableData<>(result.getTotal(), result.getResult());
    }

}
