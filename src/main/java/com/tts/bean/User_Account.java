package com.tts.bean;

import java.io.Serializable;

/**
 * Created by joe on 17/4/17.
 */
public class User_Account implements Serializable {

    private long uaId;
    private double uaMoney;
    private User_Red_package userRedPackage;
    private Discount_coupon discountCoupon;
    private Users users;

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
