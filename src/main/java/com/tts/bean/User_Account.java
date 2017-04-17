package com.tts.bean;

import java.io.Serializable;

/**
 * 用户账户
 * Created by joe on 17/4/17.
 */
public class User_Account implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long uaId;	
    private double uaMoney;		//账户余额
    private User_Red_package userRedPackage;	//红包
    private Discount_coupon discountCoupon;		//优惠券
    private Users users;	//用户

    public User_Account() {
    }

    public long getUaId() {
        return uaId;
    }

    public void setUaId(long uaId) {
        this.uaId = uaId;
    }

    public double getUaMoney() {
        return uaMoney;
    }

    public void setUaMoney(double uaMoney) {
        this.uaMoney = uaMoney;
    }

    public User_Red_package getUserRedPackage() {
        return userRedPackage;
    }

    public void setUserRedPackage(User_Red_package userRedPackage) {
        this.userRedPackage = userRedPackage;
    }

    public Discount_coupon getDiscountCoupon() {
        return discountCoupon;
    }

    public void setDiscountCoupon(Discount_coupon discountCoupon) {
        this.discountCoupon = discountCoupon;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "User_Account{" +
                "uaId=" + uaId +
                ", uaMoney=" + uaMoney +
                ", userRedPackage=" + userRedPackage +
                ", discountCoupon=" + discountCoupon +
                ", users=" + users +
                '}';
    }
}
