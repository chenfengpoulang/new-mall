package com.mall.service;

import com.mall.entity.ProductDetail;
import com.mall.entity.ProductInfo;
import com.mall.entity.ProductTotal;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl {

    /**
     * 注入RestTemplate
     */
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "productFallback")
    public ProductTotal findById(long productId){
        String url="http://YOUFANDS-PRODUCT/productOut/findById?productId=" + productId;
        ProductTotal productTotal = restTemplate.getForObject(url,ProductTotal.class);
        return productTotal;
    }

    /**
     * 熔断方法，生产上可调用备用服务
     * @param productId
     * @return
     */
    public ProductTotal productFallback(long productId){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(35);
        productInfo.setProducttypeid(1);
        productInfo.setProducttitle("华为笔记本");
        productInfo.setProductprice(300);
        productInfo.setProductpicurl("https://img13.360buyimg.com/n7/jfs/t1/77691/1/14792/488406/5dc3f358E77367834/dd8a6f476e1db7a8.jpg");
        productInfo.setStocknum(45);
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductid(35L);
        productDetail.setProductplace("北京");
        productDetail.setProductdescription("衬衫大减价");
        productDetail.setProductbrand("卢梦");
        ProductTotal productTotal = new ProductTotal();
        productTotal.setProductInfo(productInfo);
        productTotal.setProductDetail(productDetail);
        return productTotal;
    }
}
