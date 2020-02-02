package com.mall.control;

import com.mall.entity.ProductDetail;
import com.mall.entity.ProductInfo;
import com.mall.vo.ConstomProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mall.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductControl {

    @Autowired
    private ProductService productService;


    @RequestMapping("toIssue")
    public String toIssueProduct(){
        return "issueProduct";
    }

    @RequestMapping(value = "issue",method = RequestMethod.POST)
    public void issueProduct(ProductInfo productInfo, ProductDetail productDetail){
        productService.issueProduct(productInfo,productDetail);
    }

    /**
     * 商品审核
     * @param id
     * @param auditstate
     */
    @RequestMapping(value = "approval",method = RequestMethod.GET)
    public String approvalProduct(long id, int auditstate){
        productService.updateProductAuditStatus(id,auditstate);
        return "redirect:queryAll";
    }

    /**
     * 上架 下架
     * @param id
     * @param state
     */
    @RequestMapping(value = "updateStatus",method = RequestMethod.GET)
    public String updateProductStatus(long id, int state){
        productService.updateProductStatus(id,state);
        return "redirect:queryAll";
    }

    @RequestMapping(value = "queryAll",method = RequestMethod.GET)
    public String queryAll(Model model){

        List<ProductInfo> list = productService.queryByVo(null);
        model.addAttribute("list",list);
        return "listProduct";
    }

    @RequestMapping(value = "queryAllStatusPass",method = RequestMethod.GET)
    public String queryAllStatus(Model model){
        ConstomProductInfo  constomProductInfo = new ConstomProductInfo();
        constomProductInfo.setAuditstate(1);
        List<ProductInfo> list = productService.queryByVo(constomProductInfo);
        model.addAttribute("list",list);
        return "listProduct";
    }







}
