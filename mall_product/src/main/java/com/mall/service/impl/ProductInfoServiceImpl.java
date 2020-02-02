package com.mall.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mall.dao.ProductDetailDao;
import com.mall.dao.ProductInfoDao;
import com.mall.entity.ProductDetail;
import com.mall.entity.ProductInfo;
import com.mall.service.ProductService;
import com.mall.service.SearchService;
import com.mall.vo.ConstomProductInfo;
import com.mall.vo.ProductInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductService {

    @Autowired
    private ProductInfoDao productInfoDao;
    @Autowired
    private ProductDetailDao productDetailDao;

    @Autowired
    private SearchService searchService;

    @Override
    public void issueProduct(ProductInfo productInfo, ProductDetail productDetail) {
        productInfo.setCreatetime(new Date());
        productInfo.setAuditstate(0);
        productInfo.setProudctstatus(0);
        Long successnum = productInfoDao.insertProduct(productInfo);
        if(productDetail != null){
            productDetail.setProductid(productInfo.getId());
            productDetailDao.insertProductDetail(productDetail);
        }
        JSONObject jsonObject = (JSONObject)JSON.toJSON(productInfo);
        searchService.addData(jsonObject,"youfands","product",productInfo.getId()+"");
    }

    @Override
    public Long updateProductAuditStatus(long id, int state) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(id);
        productInfo.setAuditstate(state);
        return productInfoDao.updateProductAuditStatus(productInfo);
    }

    @Override
    public Long updateProductStatus(long id, int state) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(id);
        productInfo.setProudctstatus(state);
        return productInfoDao.updateProductStatus(productInfo);
    }

    @Override
    public List<ProductInfo> queryByVo(ConstomProductInfo constomProductInfo) {
        ProductInfoVo productInfoVo = new ProductInfoVo();
        productInfoVo.setConstomProductInfo(constomProductInfo);
        return productInfoDao.queryByVo(productInfoVo);
    }
}
