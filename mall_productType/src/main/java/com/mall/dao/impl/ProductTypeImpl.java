package com.mall.dao.impl;

import com.mall.mappers.ProductTypeMapper;
import com.mall.dao.ProductTypeDao;
import com.mall.entity.ProductTypeInfo;
import com.mall.vo.ProductTypeInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductTypeImpl implements ProductTypeDao {

    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Override
    public void insertProductType(ProductTypeInfo productTypeInfo) {
        productTypeMapper.insertProductType(productTypeInfo);
    }

    @Override
    public void updateProductTypeById(ProductTypeInfo productTypeInfo) {
        productTypeMapper.updateProductTypeById(productTypeInfo);
    }

    @Override
    public ProductTypeInfo findProductTypeById(long id) {
        return productTypeMapper.findProductTypeById(id);
    }

    @Override
    public List<ProductTypeInfo> findProductTypeByVo(ProductTypeInfoVo productTypeInfoVo) {
        return productTypeMapper.findProductTypeByVo(productTypeInfoVo);
    }
}
