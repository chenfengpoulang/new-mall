package com.mall.control;

import com.alibaba.fastjson.JSONObject;
import com.mall.entity.ProductInfo;
import com.mall.entity.ProductTotal;
import com.mall.entity.ProductTypeInfo;
import com.mall.page.EsPage;
import com.mall.service.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("productlist")
public class ProductControl {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private SearchService searchService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private ProductRibbonService productRibbonService;

    @Autowired
    private ProductTypeRibbonService productTypeRibbonService;

    @RequestMapping(value = "listProduct")
    public String listProductByTypeId(long productypeid, Model model){
        List<ProductInfo> list = productService.queryAll(productypeid);
        List<ProductTypeInfo> productTypeInfoList = productTypeRibbonService.listAllProductType(-1);
        model.addAttribute("list",list);
        model.addAttribute("typelist",productTypeInfoList);
        return "listProduct";

    }

    @RequestMapping(value = "/indexproduct")
    public String indexproduct(long productypeid, Model model){
        Map<ProductTypeInfo,List<ProductTypeInfo>> datamap = new HashMap<ProductTypeInfo,List<ProductTypeInfo>>();
        List<ProductTypeInfo> list = productTypeRibbonService.listAllProductType(-1);
        for(ProductTypeInfo productType:list){
            long parentid = productType.getId();
            List<ProductTypeInfo> innerlist = productTypeRibbonService.listAllProductType(parentid);
            datamap.put(productType,innerlist);
        }
        model.addAttribute("datamap",datamap);
        model.addAttribute("productypelist",list);
        if(productypeid == -1){
            productypeid = list.get(0).getId();
        }
        List<ProductInfo> productlist = productService.queryAll(productypeid);
        List<List<ProductInfo>> productlistfinal = new ArrayList<List<ProductInfo>>();
        List<ProductInfo> innerlist = new ArrayList<ProductInfo>();
        for(int i=0;i<productlist.size();i++){
            innerlist.add(productlist.get(i));
            if((i+1)%3==0){
                productlistfinal.add(innerlist);
                innerlist = new ArrayList<ProductInfo>();
            }
        }
        if(productlist.size()%3 != 0){
            productlistfinal.add(innerlist);
        }
        model.addAttribute("productlistfinal",productlistfinal);
        return "beautiful/index";
    }

    @RequestMapping(value = "/searchProduct")
    public String searchProduct(int type, String searchword, Model model){
        Map<ProductTypeInfo,List<ProductTypeInfo>> datamap = new HashMap<ProductTypeInfo,List<ProductTypeInfo>>();
        List<ProductTypeInfo> list = productTypeRibbonService.listAllProductType(-1);
        for(ProductTypeInfo productType:list){
            long parentid = productType.getId();
            List<ProductTypeInfo> innerlist = productTypeRibbonService.listAllProductType(parentid);
            datamap.put(productType,innerlist);
        }
        model.addAttribute("datamap",datamap);
        model.addAttribute("productypelist",list);
        long productypeid = list.get(0).getId();
        EsPage esPage = searchService.searchDataPage("youfands","product",0,1,false,"producttitle","productprice","producttitle",searchword,"producttitle,productprice,auditstate,proudctstatus,stocknum,auditstate,productpicurl");
        List<Map<String, Object>> resultList = esPage.getRecordList();
        List<ProductInfo> productlist = new ArrayList<ProductInfo>();
        for(Map<String,Object> map:resultList){
           ProductInfo productInfo =  JSONObject.parseObject(JSONObject.toJSONString(map),ProductInfo.class);
           productlist.add(productInfo);
        }
        List<List<ProductInfo>> productlistfinal = new ArrayList<List<ProductInfo>>();
        List<ProductInfo> innerlist = new ArrayList<ProductInfo>();
        for(int i=0;i<productlist.size();i++){
            innerlist.add(productlist.get(i));
            if((i+1)%3==0){
                productlistfinal.add(innerlist);
                innerlist = new ArrayList<ProductInfo>();
            }
        }
        if(productlist.size()%3 != 0){
            productlistfinal.add(innerlist);
        }
        model.addAttribute("productlistfinal",productlistfinal);
        return "beautiful/index";
    }


    @RequestMapping(value = "/findProductById")
    public String findProductById(long productId, Model model){
        //先查分布式redis缓存，再查本地缓存,最后再查数据库
        String productTotalString = redisService.getStr("product:"+productId);
        ProductTotal productTotal = null;
        if(StringUtils.isBlank(productTotalString)){
            productTotal = productRibbonService.findById(productId);
            //productTotal = productService.findById(productId);
            String productTotalJson = JSONObject.toJSONString(productTotal);
            redisService.setStr("product:"+productId,productTotalJson);
        }else {
            productTotal = JSONObject.parseObject(productTotalString,ProductTotal.class);
        }

        model.addAttribute("productTotal",productTotal);

        Map<ProductTypeInfo,List<ProductTypeInfo>> datamap = new HashMap<ProductTypeInfo,List<ProductTypeInfo>>();
        List<ProductTypeInfo> list = productTypeRibbonService.listAllProductType(-1);
        for(ProductTypeInfo productType:list){
            long parentid = productType.getId();
            List<ProductTypeInfo> innerlist = productTypeRibbonService.listAllProductType(parentid);
            datamap.put(productType,innerlist);
        }
        model.addAttribute("datamap",datamap);
        model.addAttribute("productypelist",list);
        return "beautiful/single";
    }
}
