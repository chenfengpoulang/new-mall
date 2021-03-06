package com.mall.control;

import com.mall.entity.ProductTotal;
import com.mall.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/product")
public class ProductControl {
    @Autowired
    private ProductServiceImpl productService;

    @RequestMapping(value = "findById",method = RequestMethod.GET)
    public ProductTotal findById(@RequestParam long productId){
        ProductTotal productTotal = productService.findById(productId);
        return productTotal;
    }

}
