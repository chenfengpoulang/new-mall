package com.mall.service;

import com.mall.entity.Orderdetail;
import com.mall.entity.Ordermain;
import com.mall.vo.ConstomOrderInfo;

import java.util.List;

public interface OrderService {

    public void insertOrder(Ordermain ordermain, List<Orderdetail> orderdetaillist);
    public List<Ordermain> findOrderByVo(ConstomOrderInfo constomOrderInfo);
    public void updateOrderInfoById(Ordermain ordermain);
    public Ordermain findOrderInfoById(long id);
    public void updateOrderInfoStatus(Ordermain ordermain);
    public void checkOrderTime();
    public void pushOrderTime();
}
