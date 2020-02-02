package com.mall.dao.impl;

import com.mall.mappers.OrderDetailMapper;
import com.mall.dao.OrderDetailDao;
import com.mall.entity.Orderdetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailDaoImpl implements OrderDetailDao {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public void insertOrderDetail(Orderdetail orderdetail) {
        orderDetailMapper.insertOrderDetail(orderdetail);
    }
}
