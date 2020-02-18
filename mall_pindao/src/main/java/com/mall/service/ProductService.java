package com.mall.service;

import com.mall.entity.ProductInfo;
import com.mall.entity.ProductTotal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 废弃，采用ribbon
 */
@FeignClient(value = "mall-product")
public interface ProductService {

    @RequestMapping(value = "productOut/queryAll",method = RequestMethod.GET)
    public List<ProductInfo> queryAll(@RequestParam(value = "productTypeid") long productTypeid);

    @RequestMapping(value = "productOut/findById",method = RequestMethod.GET)
    public ProductTotal findById(@RequestParam(value = "productId") long productId);
}
