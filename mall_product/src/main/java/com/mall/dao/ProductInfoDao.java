package com.mall.dao;

import com.mall.entity.ProductInfo;
import com.mall.vo.ProductInfoVo;

import java.util.List;

public interface ProductInfoDao {
    public Long  insertProduct(ProductInfo productInfo);
    public Long updateProductAuditStatus(ProductInfo productInfo);
    public Long updateProductStatus(ProductInfo productInfo);
    public List<ProductInfo> queryByVo(ProductInfoVo productInfoVo);
    public ProductInfo findProductById(Long id);
    public ProductInfo updateProductInfo(Long id, String productTile, double productPrice);
}
