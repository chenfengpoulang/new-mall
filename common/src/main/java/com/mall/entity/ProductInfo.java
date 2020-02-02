package com.mall.entity;

import java.util.Date;

public class ProductInfo {
    private long id;
    private long producttypeid;
    private String producttitle;
    private double productprice;
    private long mechartid;
    private Date createtime;
    private Date audittime;
    private int auditstate;//0 未审核 1 审核通过 2 审核不通过
    private int stocknum;
    private long sellnum;
    private String productpicurl;
    private int proudctstatus;

    public long getProducttypeid() {
        return producttypeid;
    }

    public void setProducttypeid(long producttypeid) {
        this.producttypeid = producttypeid;
    }

    public String getProducttitle() {
        return producttitle;
    }

    public void setProducttitle(String producttitle) {
        this.producttitle = producttitle;
    }

    public double getProductprice() {
        return productprice;
    }

    public void setProductprice(double productprice) {
        this.productprice = productprice;
    }

    public long getMechartid() {
        return mechartid;
    }

    public void setMechartid(long mechartid) {
        this.mechartid = mechartid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getAudittime() {
        return audittime;
    }

    public void setAudittime(Date audittime) {
        this.audittime = audittime;
    }

    public int getAuditstate() {
        return auditstate;
    }

    public void setAuditstate(int auditstate) {
        this.auditstate = auditstate;
    }

    public int getStocknum() {
        return stocknum;
    }

    public void setStocknum(int stocknum) {
        this.stocknum = stocknum;
    }

    public long getSellnum() {
        return sellnum;
    }

    public void setSellnum(long sellnum) {
        this.sellnum = sellnum;
    }

    public String getProductpicurl() {
        return productpicurl;
    }

    public void setProductpicurl(String productpicurl) {
        this.productpicurl = productpicurl;
    }

    public int getProudctstatus() {
        return proudctstatus;
    }

    public void setProudctstatus(int proudctstatus) {
        this.proudctstatus = proudctstatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
