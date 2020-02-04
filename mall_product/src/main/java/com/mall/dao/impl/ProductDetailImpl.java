package com.mall.dao.impl;

import com.mall.entity.ProductDetail;
import com.mall.entity.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import com.mall.dao.ProductDetailDao;
import com.mall.mappers.ProductDetailMapper;

@Component
@CacheConfig(cacheNames = "ProductCache")
public class ProductDetailImpl implements ProductDetailDao {

    @Autowired
    private ProductDetailMapper productDetailMapper;

    @Override
    public void insertProductDetail(ProductDetail productDetail) {
        productDetailMapper.insertProductDetail(productDetail);
    }


    @Override
    @Cacheable(value = "ProductCache",key = "'productDetail'+#id")
    public ProductDetail findProductDetailByProductId(Long id) {
        System.out.println("findProductDetailByProductId");
        ProductInfo productInfo = new ProductInfo();
        return  productDetailMapper.findProductDetailByProductId(productInfo);
    }
}
