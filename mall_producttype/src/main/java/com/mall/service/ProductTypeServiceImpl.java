package com.mall.service;

import com.mall.dao.ProductTypeDao;
import com.mall.entity.ProductTypeInfo;
import com.mall.vo.ConstomProductTypeInfo;
import com.mall.vo.ProductTypeInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeDao productTypeDao;

    @Override
    public void insertProductType(ProductTypeInfo productTypeInfo) {
            productTypeDao.insertProductType(productTypeInfo);
    }

    @Override
    public void updateProductTypeById(ProductTypeInfo productTypeInfo) {
        productTypeDao.updateProductTypeById(productTypeInfo);
    }

    @Override
    public ProductTypeInfo findProductTypeById(long id) {
        ProductTypeInfo productTypeInfo = productTypeDao.findProductTypeById(id);
        if(productTypeInfo.getParentid() != -1){
            ProductTypeInfo parent = productTypeDao.findProductTypeById(productTypeInfo.getParentid());
            productTypeInfo.setParent(parent);
        }else{
            ProductTypeInfo productTypeInfo1 = new ProductTypeInfo();
            productTypeInfo1.setProducttypename("没有父类");
            productTypeInfo.setParent(productTypeInfo1);
        }
        return productTypeInfo;
    }

    @Override
    public List<ProductTypeInfo> findProductTypeByVo(ConstomProductTypeInfo constomProductTypeInfo) {
        ProductTypeInfoVo productTypeInfoVo = new ProductTypeInfoVo();
        productTypeInfoVo.setConstomProductTypeInfo(constomProductTypeInfo);
        return productTypeDao.findProductTypeByVo(productTypeInfoVo);
    }
}
