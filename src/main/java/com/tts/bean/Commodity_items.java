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
    //一对多 商品 键--商品 值--数量
    private Map<Commodity, Integer> commodities = new HashMap<>();
    private Commodity_type commodityType;    //商品样式
    private Commodity_Combo commodityCombo;    //商品套餐

    public Commodity_items() {
    }

    @Override
    public String toString() {
        return "Commodity_items{" +
                "ciId=" + ciId +
                ", commodities=" + commodities +
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

    public Map<Commodity, Integer> getCommodities() {
        return commodities;
    }

    public void setCommodities(Map<Commodity, Integer> commodities) {
        this.commodities = commodities;
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
}