package com.tts.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 商品表
 */
public class Commodity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private long cid;
    private String cname;      //商品名
    private String category;  //商品类别
    private double price;      //商品原价格 不含套餐
    private Integer postage;  //商品运费
    private double forSalePrice;  //打折价
    private Integer number;        //库存
    //一对多 套餐
    private Set<Commodity_Combo> combos = new HashSet<>();
    //一对多 类型
    private Set<Commodity_type> commodityTypes = new HashSet<>();
    //一对多 评论
    private Set<Commodity_Comment> comments = new HashSet<>();
    //一对多 商品图
    private Set<Commodity_pics> commodityPics = new HashSet<>();

    public Commodity() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Set<Commodity_Combo> getCombos() {
        return combos;
    }

    public void setCombos(Set<Commodity_Combo> combos) {
        this.combos = combos;
    }

    public Set<Commodity_type> getCommodityTypes() {
        return commodityTypes;
    }

    public void setCommodityTypes(Set<Commodity_type> commodityTypes) {
        this.commodityTypes = commodityTypes;
    }

    public Set<Commodity_Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Commodity_Comment> comments) {
        this.comments = comments;
    }

    public Set<Commodity_pics> getCommodityPics() {
        return commodityPics;
    }

    public void setCommodityPics(Set<Commodity_pics> commodityPics) {
        this.commodityPics = commodityPics;
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
                ", combos=" + combos +
                ", commodityTypes=" + commodityTypes +
                ", comments=" + comments +
                ", commodityPics=" + commodityPics +
                '}';
    }
}
