package com.mall.mappers;

import com.mall.entity.Ordermain;
import com.mall.vo.OrderInfoVo;

import java.util.List;

public interface OrderInfoMapper {
    public void insertOrderMain(Ordermain ordermain);
    public List<Ordermain> findOrderByVo(OrderInfoVo orderInfoVo);
    public void updateOrderInfoById(Ordermain ordermain);
    public Ordermain findOrderInfoById(long id);
    public void updateOrderInfoStatus(Ordermain ordermain);
    public Ordermain findOrderInofByTradenumber(String tradenumber);
}
