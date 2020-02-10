package com.mall.control;

import com.mall.entity.ProductTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/product")
public class ProductControl {
    /**
     * 注入RestTemplate
     */
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "findById",method = RequestMethod.GET)
    public ProductTotal findById(@RequestParam long productId){
        String url="http://MALL-PRODUCT/productOut/findById?productId="+productId;
        ProductTotal productTotal = restTemplate.getForObject(url,ProductTotal.class);
        return productTotal;
    }

}
