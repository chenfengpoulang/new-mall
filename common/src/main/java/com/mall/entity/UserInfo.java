package com.mall.entity;

public class UserInfo {
    private Long id;
    private String account;
    private String passwordplaintext;
    private String passwordencrypt;
    private String name;
    private int age;
    private String address;
    private String telphone;
    private String qq;
    private String weixin;
    private String email;
    private String sex;
    private String birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswordplaintext() {
        return passwordplaintext;
    }

    public void setPasswordplaintext(String passwordplaintext) {
        this.passwordplaintext = passwordplaintext;
    }

    public String getPasswordencrypt() {
        return passwordencrypt;
    }

    public void setPasswordencrypt(String passwordencrypt) {
        this.passwordencrypt = passwordencrypt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
