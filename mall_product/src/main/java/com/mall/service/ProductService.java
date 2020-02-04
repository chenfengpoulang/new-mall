package com.mall.service;

import com.mall.entity.ProductDetail;
import com.mall.entity.ProductInfo;
import com.mall.entity.ProductTotal;
import com.mall.vo.ConstomProductInfo;

import java.util.List;

public interface ProductService {
    public void issueProduct(ProductInfo productInfo, ProductDetail productDetail);
    public Long updateProductAuditStatus(long id, int auditstate);
    public Long updateProductStatus(long id, int state);
    public List<ProductInfo> queryByVo(ConstomProductInfo constomProductInfo);
    public ProductTotal findProductById(Long id);
    public ProductInfo updateProductBy(Long id, String productTile, double productPrice);
}
