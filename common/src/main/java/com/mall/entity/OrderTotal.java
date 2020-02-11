package com.mall.entity;

public class OrderTotal {
    private Ordermain ordermain;
    private Orderdetail orderdetail;

    public Ordermain getOrdermain() {
        return ordermain;
    }

    public void setOrdermain(Ordermain ordermain) {
        this.ordermain = ordermain;
    }

    public Orderdetail getOrderdetail() {
        return orderdetail;
    }

    public void setOrderdetail(Orderdetail orderdetail) {
        this.orderdetail = orderdetail;
    }
}
