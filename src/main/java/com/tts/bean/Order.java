package com.tts.bean;

import java.io.Serializable;

/**
 * 订单
 * Created by joe on 17/4/17.
 */
public class Order implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long oid;	
    private Shopping_Cart shopping_cart;  //购物车
    private double money;	//总金额
    private Integer status;	//订单状态
    private Discount_coupon discountCoupon;		//优惠券
    private User_Red_package userRedPackage;	//红包
    private User_address userAddress;	//用户地址

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
