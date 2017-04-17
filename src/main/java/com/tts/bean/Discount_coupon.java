package com.tts.bean;

import java.io.Serializable;

/**
 * 商品优惠券
 * Created by joe on 17/4/17.
 */
public class Discount_coupon implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long dcId;	
    private Integer condition;		//优惠券条件
    private Commodity commodity;	//商品
    private double reduce;   		//减多少钱

    
    public double getReduce() {
		return reduce;
	}

	public void setReduce(double reduce) {
		this.reduce = reduce;
	}

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
		return "Discount_coupon [dcId=" + dcId + ", condition=" + condition + ", commodity=" + commodity + ", reduce="
				+ reduce + "]";
	}

    
}
