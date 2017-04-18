package com.tts.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户账户
 */
public class User_Account implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long uaId;
    //账户余额
    private double uaMoney;
    //一对多 红包
    private Set<User_Red_package> userRedPackages = new HashSet<>();
    //一对多 优惠券
    private Set<Discount_coupon> discountCoupons = new HashSet<>();

    public User_Account() {
    }

    @Override
    public String toString() {
        return "User_Account{" +
                "uaId=" + uaId +
                ", uaMoney=" + uaMoney +
                ", userRedPackages=" + userRedPackages +
                ", discountCoupons=" + discountCoupons +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Set<User_Red_package> getUserRedPackages() {
        return userRedPackages;
    }

    public void setUserRedPackages(Set<User_Red_package> userRedPackages) {
        this.userRedPackages = userRedPackages;
    }

    public Set<Discount_coupon> getDiscountCoupons() {
        return discountCoupons;
    }

    public void setDiscountCoupons(Set<Discount_coupon> discountCoupons) {
        this.discountCoupons = discountCoupons;
    }
}
