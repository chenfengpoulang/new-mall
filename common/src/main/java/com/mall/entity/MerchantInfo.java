package com.mall.entity;

import lombok.Data;

/**
 * Created by zhangxiaodong on 2019/12/22 7:58 下午
 */


public class MerchantInfo {
    private long id;
    private String merchantname;
    private String merchantaccount;
    private String mechantpassword;
    private String mechantscope;
    private int auditstatus;
    private int soldout;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMerchantname() {
        return merchantname;
    }

    public void setMerchantname(String merchantname) {
        this.merchantname = merchantname;
    }

    public String getMerchantaccount() {
        return merchantaccount;
    }

    public void setMerchantaccount(String merchantaccount) {
        this.merchantaccount = merchantaccount;
    }

    public String getMechantpassword() {
        return mechantpassword;
    }

    public void setMechantpassword(String mechantpassword) {
        this.mechantpassword = mechantpassword;
    }

    public String getMechantscope() {
        return mechantscope;
    }

    public void setMechantscope(String mechantscope) {
        this.mechantscope = mechantscope;
    }

    public int getAuditstatus() {
        return auditstatus;
    }

    public void setAuditstatus(int auditstatus) {
        this.auditstatus = auditstatus;
    }

    public int getSoldout() {
        return soldout;
    }

    public void setSoldout(int soldout) {
        this.soldout = soldout;
    }
}
