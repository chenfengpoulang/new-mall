package com.mall.service;

import com.mall.entity.ProductTypeInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductTypeServiceImpl {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "productTypeFallback")
    public List<ProductTypeInfo> listAllProductType(long parentId){
        int i = 10/0;
        String url = "http://MALL-PRODUCTTYPE/productOutType/list?parentId=" + parentId;
        List<ProductTypeInfo> productTypes =  restTemplate.getForObject(url,List.class);
        return productTypes;
    }

    /**
     * 熔断方法，生产上可调用备用服务
     * @param parentId
     * @return
     */
    public List<ProductTypeInfo> productTypeFallback(long parentId){
        ProductTypeInfo productTypeInfo = new ProductTypeInfo();
        productTypeInfo.setId(10l);
        productTypeInfo.setParentid(1l);
        productTypeInfo.setProducttypename("衣服");
        productTypeInfo.setProducttypedescription("衣服品类");
        productTypeInfo.setTypegrade(1l);
        List<ProductTypeInfo> list = new LinkedList<>();
        list.add(productTypeInfo);
        return list;
    }
}
