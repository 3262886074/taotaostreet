package com.tts.bean;

import java.io.Serializable;

/**
 * 商品优惠券
 */
public class Discount_coupon implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private long dcId;
    private Integer condition;        //优惠券条件
    private double reduce;        //减多少钱

    public Discount_coupon() {
    }

    @Override
    public String toString() {
        return "Discount_coupon{" +
                "dcId=" + dcId +
                ", condition=" + condition +
                ", reduce=" + reduce +
                '}';
    }

    public Discount_coupon(long dcId, Integer condition, double reduce) {
        this.dcId = dcId;
        this.condition = condition;
        this.reduce = reduce;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getDcId() {
        return dcId;
    }

    public void setDcId(long dcId) {
        this.dcId = dcId;
    }

    public Integer getCondition() {
        return condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    public double getReduce() {
        return reduce;
    }

    public void setReduce(double reduce) {
        this.reduce = reduce;
    }
}
