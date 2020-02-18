package com.mall.dao.impl;

import com.mall.mappers.OrderInfoMapper;
import com.mall.dao.OrderInfoDao;
import com.mall.entity.Ordermain;
import com.mall.vo.OrderInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderInfoDaoImpl implements OrderInfoDao {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    public void insertOrderMain(Ordermain ordermain) {
        orderInfoMapper.insertOrderMain(ordermain);
    }

    @Override
    public List<Ordermain> findOrderByVo(OrderInfoVo orderInfoVo) {
        return orderInfoMapper.findOrderByVo(orderInfoVo);
    }

    @Override
    public void updateOrderInfoById(Ordermain ordermain) {
        orderInfoMapper.updateOrderInfoById(ordermain);
    }

    @Override
    public Ordermain findOrderInfoById(long id) {
        return orderInfoMapper.findOrderInfoById(id);
    }

    @Override
    public void updateOrderInfoStatus(Ordermain ordermain) {
        orderInfoMapper.updateOrderInfoStatus(ordermain);
    }

    @Override
    public Ordermain findOrderInofByTradenumber(String tradenumber) {
        return orderInfoMapper.findOrderInofByTradenumber(tradenumber);
    }
}
