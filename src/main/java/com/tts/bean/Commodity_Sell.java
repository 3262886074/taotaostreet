package com.tts.bean;

/**
 * 商品销售量统计
 * @author Admin
 *
 */
public class Commodity_Sell {

	private Integer monthSell; //月销售量
	private Integer allSell;   //累计销售量
	private Integer allComm;   //累计评论
	
	
	public Integer getMonthSell() {
		return monthSell;
	}
	public void setMonthSell(Integer monthSell) {
		this.monthSell = monthSell;
	}
	public Integer getAllSell() {
		return allSell;
	}
	public void setAllSell(Integer allSell) {
		this.allSell = allSell;
	}
	public Integer getAllComm() {
		return allComm;
	}
	public void setAllComm(Integer allComm) {
		this.allComm = allComm;
	}
	@Override
	public String toString() {
		return "Commodity_Sell [月销售量=" + monthSell + ", 累计销售量=" + allSell + ", 累计评价=" + allComm + "]";
	}
	
	
	
}
