package com.tts.bean;

import java.io.Serializable;

/**
 * 购物车
 * Created by joe on 17/4/17.
 */
public class Shopping_Cart implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long scId;
    private Commodity_items commodityItems;  //商品条目
    private Users users;	//购买用户

    public Shopping_Cart() {
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

    @Override
    public String toString() {
        return "Shopping_Cart{" +
                "scId=" + scId +
                ", commodityItems=" + commodityItems +
                ", users=" + users +
                '}';
    }
}
