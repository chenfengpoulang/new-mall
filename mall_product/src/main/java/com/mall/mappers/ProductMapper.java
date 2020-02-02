package com.mall.mappers;

import com.mall.entity.ProductInfo;
import com.mall.vo.ProductInfoVo;

import java.util.List;

public interface ProductMapper {
    public Long insertProduct(ProductInfo productInfo);
    public Long updateProductAuditStatus(ProductInfo productInfo);
    public Long updateProductStatus(ProductInfo productInfo);
    public List<ProductInfo> queryByVo(ProductInfoVo productInfoVo);
}
