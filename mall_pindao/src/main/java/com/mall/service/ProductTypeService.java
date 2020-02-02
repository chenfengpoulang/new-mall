package com.mall.service;

import com.mall.entity.ProductTypeInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "mall-productType")
public interface ProductTypeService {

    @RequestMapping(value = "productOutType/list")
    public List<ProductTypeInfo> listAllProductType(@RequestParam(value = "parentId") long parentId);
}
