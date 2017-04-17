package com.tts.bean;

import java.io.Serializable;

/**
 * Created by joe on 17/4/17.
 */
public class Commodity_items implements Serializable {

    private long ciId;
    private Commodity commodity;
    private Commodity_type commodityType;
    private Commodity_Combo commodityCombo;
    private Integer number;

    public Commodity_items() {
    }

    public long getCiId() {
        return ciId;
    }

    public void setCiId(long ciId) {
        this.ciId = ciId;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Commodity_type getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(Commodity_type commodityType) {
        this.commodityType = commodityType;
    }

    public Commodity_Combo getCommodityCombo() {
        return commodityCombo;
    }

    public void setCommodityCombo(Commodity_Combo commodityCombo) {
        this.commodityCombo = commodityCombo;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Commodity_items{" +
                "ciId=" + ciId +
                ", commodity=" + commodity +
                ", commodityType=" + commodityType +
                ", commodityCombo=" + commodityCombo +
                ", number=" + number +
                '}';
    }
}
