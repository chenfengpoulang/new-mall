package com.mall.dao.impl;

import com.mall.dao.ProductInfoDao;
import com.mall.entity.ProductInfo;
import com.mall.vo.ProductInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import com.mall.mappers.ProductMapper;

import java.util.List;

@Component
@CacheConfig(cacheNames = "ProductCache")
public class ProductInfoImpl implements ProductInfoDao {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Long insertProduct(ProductInfo productInfo) {
        return productMapper.insertProduct(productInfo);
    }

    @Override
    public Long updateProductAuditStatus(ProductInfo productInfo) {
        return productMapper.updateProductAuditStatus(productInfo);
    }

    @Override
    public Long updateProductStatus(ProductInfo productInfo) {
        return productMapper.updateProductStatus(productInfo);
    }

    @Override
    public List<ProductInfo> queryByVo(ProductInfoVo productInfoVo) {
        return productMapper.queryByVo(productInfoVo);
    }

    @Override
    @Cacheable(value = "ProductCache",key = "'productinfo'+#id")
    public ProductInfo findProductById(Long id) {
        System.out.println("findProductById");
        ProductInfo productInfo = new ProductInfo();

        productInfo.setId(id);
        return productMapper.findProductById(productInfo);
    }

    @Override
    @CachePut(value = "ProductCache",key = "'productinfo'+#id")
    public ProductInfo updateProductInfo(Long id, String productTile, double productPrice) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(id);
        productInfo.setProducttitle(productTile);
        productInfo.setProductprice(productPrice);
        productMapper.updateProductInfo(productInfo);
        return productMapper.findProductById(productInfo);
    }
}
