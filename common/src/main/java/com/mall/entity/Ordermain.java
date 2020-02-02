package com.mall.entity;

import java.util.Date;

public class Ordermain {
    private long id;
    private double payamount;
    private long userid;
    private Date createtime;
    private Date paytime;
    private int paystatus;//支付状态,1未支付 2已支付 3已退款
    private String consigneeadress;
    private String consigneephone;
    private String consigneename;
    private String tradenumber;
    private int paytype;//支付类型 1微信支付 2支付宝支付 3银联支付
    private int orderstatus;//订单状态  1、正常 2失效'

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPayamount() {
        return payamount;
    }

    public void setPayamount(double payamount) {
        this.payamount = payamount;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public int getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(int paystatus) {
        this.paystatus = paystatus;
    }

    public String getConsigneeadress() {
        return consigneeadress;
    }

    public void setConsigneeadress(String consigneeadress) {
        this.consigneeadress = consigneeadress;
    }

    public String getConsigneephone() {
        return consigneephone;
    }

    public void setConsigneephone(String consigneephone) {
        this.consigneephone = consigneephone;
    }

    public String getConsigneename() {
        return consigneename;
    }

    public void setConsigneename(String consigneename) {
        this.consigneename = consigneename;
    }

    public String getTradenumber() {
        return tradenumber;
    }

    public void setTradenumber(String tradenumber) {
        this.tradenumber = tradenumber;
    }

    public int getPaytype() {
        return paytype;
    }

    public void setPaytype(int paytype) {
        this.paytype = paytype;
    }

    public int getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(int orderstatus) {
        this.orderstatus = orderstatus;
    }

    @Override
    public String toString() {
        return "Ordermain{" +
                "id=" + id +
                ", payamount=" + payamount +
                ", userid=" + userid +
                ", createtime=" + createtime +
                ", paytime=" + paytime +
                ", paystatus=" + paystatus +
                ", consigneeadress='" + consigneeadress + '\'' +
                ", consigneephone='" + consigneephone + '\'' +
                ", consigneename='" + consigneename + '\'' +
                ", tradenumber='" + tradenumber + '\'' +
                ", paytype=" + paytype +
                ", orderstatus=" + orderstatus +
                '}';
    }
}
