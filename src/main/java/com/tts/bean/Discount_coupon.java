package com.tts.bean;

import java.io.Serializable;

/**
 * Created by joe on 17/4/17.
 */
public class Discount_coupon implements Serializable {

    private long dcId;
    private Integer condition;
    private Commodity commodity;

    public Discount_coupon() {
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

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    @Override
    public String toString() {
        return "Discount_coupon{" +
                "dcId=" + dcId +
                ", condition=" + condition +
                ", commodity=" + commodity +
                '}';
    }
}
