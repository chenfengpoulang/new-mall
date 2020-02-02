package com.mall.dao.impl;

import com.mall.dao.ProductInfoDao;
import com.mall.entity.ProductInfo;
import com.mall.vo.ProductInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mall.mappers.ProductMapper;

import java.util.List;

@Component
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
}
