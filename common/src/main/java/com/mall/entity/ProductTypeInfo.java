package com.mall.entity;

public class ProductTypeInfo {
    private Long id;
    private String producttypename;
    private String  producttypedescription;
    private Long  typegrade;
    private Long parentid;
    private ProductTypeInfo parent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducttypename() {
        return producttypename;
    }

    public void setProducttypename(String producttypename) {
        this.producttypename = producttypename;
    }

    public String getProducttypedescription() {
        return producttypedescription;
    }

    public void setProducttypedescription(String producttypedescription) {
        this.producttypedescription = producttypedescription;
    }

    public Long getTypegrade() {
        return typegrade;
    }

    public void setTypegrade(Long typegrade) {
        this.typegrade = typegrade;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public ProductTypeInfo getParent() {
        return parent;
    }

    public void setParent(ProductTypeInfo parent) {
        this.parent = parent;
    }
}
