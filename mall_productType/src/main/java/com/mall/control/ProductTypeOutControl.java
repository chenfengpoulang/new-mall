package com.mall.control;

import com.mall.entity.ProductTypeInfo;
import com.mall.service.ProductTypeService;
import com.mall.vo.ConstomProductTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("productOutType")
public class ProductTypeOutControl {

    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping(value = "list")
    public List<ProductTypeInfo> listAllProductType(@RequestParam(value = "parentId") long parentId){
        ConstomProductTypeInfo constomProductTypeInfo = new ConstomProductTypeInfo();
        constomProductTypeInfo.setParentid(parentId);
        List<ProductTypeInfo> list = productTypeService.findProductTypeByVo(constomProductTypeInfo);
        return list;
    }


}
