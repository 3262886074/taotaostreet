package com.tts.bean;

import java.io.Serializable;

/**
 * Created by joe on 17/4/17.
 * 商品表
 */
public class Commodity implements Serializable {

    private long cid;
    private String cname;
    private String category;
    private double price;
    private Integer postage;
    private double forSalePrice;
    private Integer number;

    public Commodity() {
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getPostage() {
        return postage;
    }

    public void setPostage(Integer postage) {
        this.postage = postage;
    }

    public double getForSalePrice() {
        return forSalePrice;
    }

    public void setForSalePrice(double forSalePrice) {
        this.forSalePrice = forSalePrice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", postage=" + postage +
                ", forSalePrice=" + forSalePrice +
                ", number=" + number +
                '}';
    }
}
