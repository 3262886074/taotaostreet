package com.tts.bean;

import java.io.Serializable;

/**
 * 购物车
 */
public class Shopping_Cart implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long scId;
	//商品条目 一对一
    private Commodity_items commodityItems;
    //用户 多对一
	private Users users;

	public Shopping_Cart() {
	}

	@Override
	public String toString() {
		return "Shopping_Cart{" +
				"scId=" + scId +
				", commodityItems=" + commodityItems +
				", users=" + users +
				'}';
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public long getScId() {
		return scId;
	}

	public void setScId(long scId) {
		this.scId = scId;
	}

	public Commodity_items getCommodityItems() {
		return commodityItems;
	}

	public void setCommodityItems(Commodity_items commodityItems) {
		this.commodityItems = commodityItems;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
}
