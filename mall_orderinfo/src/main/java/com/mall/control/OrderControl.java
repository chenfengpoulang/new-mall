package com.mall.control;

import com.mall.entity.Orderdetail;
import com.mall.entity.Ordermain;
import com.mall.service.OrderService;
import com.mall.vo.ConstomOrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "orderinfo")
public class OrderControl {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "toInsertOrder")
    public String toInsertOrder(){
        return "insertOrder";
    }

    @RequestMapping(value = "insertOrder")
    public void insertOrder(Ordermain ordermain, Orderdetail orderdetail){
            List<Orderdetail> detailList = new ArrayList<Orderdetail>();
            detailList.add(orderdetail);
            orderService.insertOrder(ordermain,detailList);
    }

    @RequestMapping(value = "listOrder")
    public String listOrder(Model model) {
        List<Ordermain> orderList = orderService.findOrderByVo(null);
        model.addAttribute("orderlist",orderList);
        return "orderList";
    }

    @RequestMapping(value = "listOrderByUserId")
    public String listOrderByUserId(long userid, Model model) {
        ConstomOrderInfo constomOrderInfo = new ConstomOrderInfo();
        constomOrderInfo.setUserid(userid);
        List<Ordermain> orderList = orderService.findOrderByVo(constomOrderInfo);
        model.addAttribute("orderlist",orderList);
        return "orderList";
    }

    @RequestMapping(value = "findOrderInfoById")
    public String findOrderInfoById(long id,Model model) {
        Ordermain ordermain = orderService.findOrderInfoById(id);
        model.addAttribute("ordermain",ordermain);
        return "viewOrder";
    }

    @RequestMapping(value = "toupdateOrder")
    public String toupdateOrder(long orderid, Model model) {
        Ordermain ordermain = orderService.findOrderInfoById(orderid);
        model.addAttribute("ordermain",ordermain);
        return "toUpdateOrder";
    }

    @RequestMapping(value = "updateOrderInfoById")
    public String updateOrderInfoById(Ordermain ordermain, Model model) {
        orderService.updateOrderInfoById(ordermain);
        return "redirect:listOrder";
    }

    @RequestMapping(value = "checkOrderTime")
    public void checkOrderTime() {
        orderService.checkOrderTime();
    }

    @RequestMapping(value = "pushOrderTime")
    public void pushOrderTime() {
        orderService.pushOrderTime();
    }
}
