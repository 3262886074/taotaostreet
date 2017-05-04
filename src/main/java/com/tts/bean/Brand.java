package com.tts.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 商品品牌
 * 
 * @author SYY
 *
 */
public class Brand implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long bid;
	private String bname;
	private List<Commodity> commodity;

	@Override
	public String toString() {
		return "Brand [bid=" + bid + ", bname=" + bname + ", commodity=" + commodity + "]";
	}

	public long getBid() {
		return bid;
	}

	public void setBid(long bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public List<Commodity> getCommodity() {
		return commodity;
	}

	public void setCommodity(List<Commodity> commodity) {
		this.commodity = commodity;
	}

}
