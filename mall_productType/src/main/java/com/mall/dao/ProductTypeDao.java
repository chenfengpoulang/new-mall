package com.mall.dao;

import com.mall.entity.ProductTypeInfo;
import com.mall.vo.ProductTypeInfoVo;

import java.util.List;

public interface ProductTypeDao {
    public void insertProductType(ProductTypeInfo productTypeInfo);
    public void updateProductTypeById(ProductTypeInfo productTypeInfo);
    public ProductTypeInfo findProductTypeById(long id);
    public List<ProductTypeInfo> findProductTypeByVo(ProductTypeInfoVo productTypeInfoVo);
}
