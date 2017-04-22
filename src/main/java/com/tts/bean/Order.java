package com.tts.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单
 */
public class Order implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private long oid;
    //所有商品总金额
    private double money;
    //订单状态 -1为未付款 0为已付款未发货 1为已发货未到货 2为已签收未评价
    private Integer status;
    private Shopping_Cart shoppingCart;  //购物车
    //优惠券 一对一
    private Discount_coupon discountCoupon;
    //红包 一对一
    private User_Red_package userRedPackage;
    //用户地址 一对一
    private User_address userAddress;
    //创建时间
    private Date createTime;

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", money=" + money +
                ", status=" + status +
                ", shopping_cart=" + shoppingCart +
                ", discountCoupon=" + discountCoupon +
                ", userRedPackage=" + userRedPackage +
                ", userAddress=" + userAddress +
                ", createTime=" + createTime +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
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

    public Shopping_Cart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Shopping_Cart shoppingCart) {
        this.shoppingCart = shoppingCart;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
