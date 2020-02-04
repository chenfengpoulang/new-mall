package com.mall.mappers;

import com.mall.entity.ProductDetail;
import com.mall.entity.ProductInfo;

public interface ProductDetailMapper {
    public void insertProductDetail(ProductDetail productDetail);
    public ProductDetail findProductDetailByProductId(ProductInfo productInfo);
}
