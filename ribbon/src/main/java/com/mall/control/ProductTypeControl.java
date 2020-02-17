package com.mall.control;

import com.mall.entity.ProductTypeInfo;
import com.mall.service.ProductTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="productType")
public class ProductTypeControl {

    @Autowired
    ProductTypeServiceImpl productTypeService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public List<ProductTypeInfo> listAllProductType(long parentId){
        List<ProductTypeInfo> productTypes =  productTypeService.listAllProductType(parentId);
        return productTypes;
    }
}
