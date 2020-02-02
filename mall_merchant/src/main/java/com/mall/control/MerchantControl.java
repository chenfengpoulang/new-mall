package com.mall.control;

import com.mall.entity.MerchantInfo;
import com.mall.service.MerchantInfoService;
import com.mall.vo.MerchantInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("merchant")
public class MerchantControl {

    @Autowired
    private MerchantInfoService merchantInfoService;


    /**
     * 跳转商家入驻页面
     * @return
     */
    @RequestMapping("toEnter")
    public String toEnteringMerchant(){
        return "enterMerchant";
    }

    /**
     * 商家入驻
     * @param merchantInfo
     */
    @RequestMapping(value = "enter",method = RequestMethod.POST)
    public void enterMerchant(MerchantInfo merchantInfo){
        merchantInfoService.insertMerchant(merchantInfo);
    }

    /**
     * 跳转商家信息更新页
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("toUpdate")
    public String toUpdateMerchant(Long id,Model model){
        MerchantInfo merchant = merchantInfoService.findMerchantById(id);
        model.addAttribute("merchantInfo",merchant);
        return "updateMerchant";
    }

    /**
     * 商家信息更新
     * @param merchantInfo
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String updateMerchant(MerchantInfo merchantInfo){
        merchantInfoService.updateMerchantById(merchantInfo);
        return "redirect:queryAll";
    }

    /**
     * 商家信息查看
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("findMerchantById")
    public String findMerchantById(Long id,Model model){
        MerchantInfo merchant = merchantInfoService.findMerchantById(id);
        model.addAttribute("merchantInfo",merchant);
        return "viewMerchant";
    }

    /**
     * 商家审核
     * @param id
     * @param auditstatus
     */
    @RequestMapping(value = "approval",method = RequestMethod.GET)
    public String approvalMerchant(long id, int auditstatus){
        merchantInfoService.updateMerchantAuditStatus(id,auditstatus);
        return "redirect:queryAll";
    }

    /**
     * 商家上架 下架
     * @param id
     * @param state
     */
    @RequestMapping(value = "updateStatus",method = RequestMethod.GET)
    public String updateMerchantStatus(long id, int state){
        merchantInfoService.updateMerchantStatus(id,state);
        return "redirect:queryAll";
    }

    @RequestMapping(value = "queryAll",method = RequestMethod.GET)
    public String queryAll(Model model){

        List<MerchantInfo> merchantInfos = merchantInfoService.queryByVo(null);
        model.addAttribute("list",merchantInfos);
        return "listMerchant";
    }

    @RequestMapping(value = "queryAllStatusPass",method = RequestMethod.GET)
    public String queryAllStatus(Model model){
        MerchantInfoVo merchantInfoVo = new MerchantInfoVo();
        merchantInfoVo.setAuditstatus(1);
        List<MerchantInfo> list = merchantInfoService.queryByVo(merchantInfoVo);
        model.addAttribute("list",list);
        return "listMerchant";
    }







}
