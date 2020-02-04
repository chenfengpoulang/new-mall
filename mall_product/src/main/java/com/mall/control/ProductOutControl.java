package com.mall.control;

import com.alibaba.fastjson.JSONObject;
import com.mall.entity.ProductInfo;
import com.mall.entity.ProductTotal;
import com.mall.service.ProductService;
import com.mall.service.RedisService;
import com.mall.vo.ConstomProductInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("productOut")
public class ProductOutControl {

    @Autowired
    private ProductService productService;
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "queryAll",method = RequestMethod.GET)
    public List<ProductInfo> queryAll(@RequestParam long productTypeid){
        if (productTypeid == -1){
            productTypeid = 4L;
        }
        ConstomProductInfo constomProductInfo = new ConstomProductInfo();
        constomProductInfo.setProducttypeid(productTypeid);
        List<ProductInfo> list = productService.queryByVo(constomProductInfo);
        return list;
    }

    @RequestMapping(value = "findById",method = RequestMethod.GET)
    public ProductTotal findById(@RequestParam long productId){
        ProductTotal productTotal = productService.findProductById(productId);
        return productTotal;
    }

    @RequestMapping(value = "updateProductBy",method = RequestMethod.GET)
    public void updateProductBy(@RequestParam long productId,@RequestParam String productTitle,@RequestParam double productPrice){
        ProductInfo productInfo = productService.updateProductBy(productId,productTitle,productPrice);
        String productTotalString = redisService.getStr("product:"+productId);
        ProductTotal productTotal = null;
        if(StringUtils.isNotBlank(productTotalString)){
            productTotal = JSONObject.parseObject(productTotalString,ProductTotal.class);
            productTotal.setProductInfo(productInfo);
            String productJson = JSONObject.toJSONString(productTotal);
            redisService.setStr("product:"+productId,productJson);
        }
    }

}
