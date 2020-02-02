package com.mall.service;

import com.mall.entity.ProductTypeInfo;
import com.mall.vo.ConstomProductTypeInfo;

import java.util.List;

public interface ProductTypeService {
    public void insertProductType(ProductTypeInfo productTypeInfo);
    public void updateProductTypeById(ProductTypeInfo productTypeInfo);
    public ProductTypeInfo findProductTypeById(long id);
    public List<ProductTypeInfo> findProductTypeByVo(ConstomProductTypeInfo constomProductTypeInfo);
}
