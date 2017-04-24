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
	private long scId;
	public long getScId() {
		return scId;
	}

	public void setScId(long scId) {
		this.scId = scId;
	}

	private Integer number;
	// 一对多 商品 键--商品 值--数量
	private Commodity commodities;
	private Commodity_type commodityType; // 商品样式
	private Commodity_Combo commodityCombo; // 商品套餐

	public Commodity_items() {
	}

	@Override
	public String toString() {
		return "Commodity_items{" + "ciId=" + ciId +
				"Commodity_items{" + "scId=" + scId +
				",number=" + number + ", commodities=" + commodities + ", commodityType=" + commodityType
				+ ", commodityCombo=" + commodityCombo + '}';
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public long getCiId() {
		return ciId;
	}

	public void setCiId(long ciId) {
		this.ciId = ciId;
	}

	public Commodity getCommodities() {
		return commodities;
	}

	public void setCommodities(Commodity commodities) {
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