package com.mall.dao.impl;

import com.mall.entity.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mall.dao.ProductDetailDao;
import com.mall.mappers.ProductDetailMapper;

@Component
public class ProductDetailImpl implements ProductDetailDao {

    @Autowired
    private ProductDetailMapper productDetailMapper;

    @Override
    public void insertProductDetail(ProductDetail productDetail) {
        productDetailMapper.insertProductDetail(productDetail);
    }
}
