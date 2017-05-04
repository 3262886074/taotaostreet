package com.tts.bean;

import java.io.Serializable;

/**
 * 商品样式
 */
public class Commodity_type implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long ctid;
    private String typeName;	//样式名
    private double price;		//不同样式的不同价格

	public Commodity_type() {
	}

	@Override
	public String toString() {
		return "Commodity_type{" +
				"ct_id=" + ctid +
				", typeName='" + typeName + '\'' +
				", price=" + price +
				'}';
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public long getCtid() {
		return ctid;
	}

	public void setCtid(long ct_id) {
		this.ctid = ct_id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
