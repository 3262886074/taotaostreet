package com.tts.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 商品条目
 */
public class Commodity_items implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long ciId;
    //商品
    private Commodity commodity;
    //数量
    private Integer number;
    private Commodity_type commodityType;    //商品样式
    private Commodity_Combo commodityCombo;    //商品套餐

    public Commodity_items() {
    }

    @Override
    public String toString() {
        return "Commodity_items{" +
                "ciId=" + ciId +
                ", commodity=" + commodity +
                ", number=" + number +
                ", commodityType=" + commodityType +
                ", commodityCombo=" + commodityCombo +
                '}';
    }

    public long getCiId() {
        return ciId;
    }

    public void setCiId(long ciId) {
        this.ciId = ciId;
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

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}