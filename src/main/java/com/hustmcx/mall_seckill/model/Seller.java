package com.hustmcx.mall_seckill.model;

/**
 * 商家实体
 */
public class Seller {
    private int id;
    private String name;
    private String shopName;
    private String account;
    private String password;
    private String scope;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shopName='" + shopName + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}
