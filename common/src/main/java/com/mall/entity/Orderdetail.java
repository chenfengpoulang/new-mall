package com.mall.entity;

import java.util.Date;

public class Orderdetail {
    private long id;
  private long orderid;
  private long productid;
  private long merchantid;
  private Date createtime;
  private long tradenum;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public long getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(long merchantid) {
        this.merchantid = merchantid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public long getTradenum() {
        return tradenum;
    }

    public void setTradenum(long tradenum) {
        this.tradenum = tradenum;
    }
}
