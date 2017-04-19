package com.tts.bean;

import java.io.Serializable;

/**
 * 用户收藏
 */
public class User_Collect implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long ucId;
	//商品 多对一
    private Commodity commodity;

	public User_Collect() {
	}

	@Override
	public String toString() {
		return "User_Collect{" +
				"ucId=" + ucId +
				", commodity=" + commodity +
				'}';
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public long getUcId() {
		return ucId;
	}

	public void setUcId(long ucId) {
		this.ucId = ucId;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
}
