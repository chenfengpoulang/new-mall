package com.mall.control;

import com.mall.entity.ProductTotal;
import com.mall.entity.ProductTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value="productType")
public class ProductTypeControl {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public List<ProductTypeInfo> listAllProductType(@RequestParam(value = "parentId") long parentId){
        String url = "http://MALL-PRODUCTTYPE/productOutType/list?parentId=" + parentId;
        List<ProductTypeInfo> productTypes =  restTemplate.getForObject(url,List.class);
        return productTypes;
    }
}
