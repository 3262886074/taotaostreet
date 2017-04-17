package com.tts.bean;

import java.io.Serializable;

/**
 * Created by joe on 17/4/17.
 */
public class Order implements Serializable {

    private long oid;
    private Shopping_Cart shopping_cart;
    private double money;
    private Integer status;
    private Discount_coupon discountCoupon;
    private User_Red_package userRedPackage;
    private User_address userAddress;

    public Order() {
    }

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public Shopping_Cart getShopping_cart() {
        return shopping_cart;
    }

    public void setShopping_cart(Shopping_Cart shopping_cart) {
        this.shopping_cart = shopping_cart;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Discount_coupon getDiscountCoupon() {
        return discountCoupon;
    }

    public void setDiscountCoupon(Discount_coupon discountCoupon) {
        this.discountCoupon = discountCoupon;
    }

    public User_Red_package getUserRedPackage() {
        return userRedPackage;
    }

    public void setUserRedPackage(User_Red_package userRedPackage) {
        this.userRedPackage = userRedPackage;
    }

    public User_address getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(User_address userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", shopping_cart=" + shopping_cart +
                ", money=" + money +
                ", status=" + status +
                ", discountCoupon=" + discountCoupon +
                ", userRedPackage=" + userRedPackage +
                ", userAddress=" + userAddress +
                '}';
    }
}
