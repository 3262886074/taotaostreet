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
	private Integer goodcomm;  //好评数量
	private Integer midcomm;   //中评数量
	private Integer badcomm;   //差评数量
	private Integer goodlv;    //好评率
	
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
	
	public Integer getGoodcomm() {
		return goodcomm;
	}
	public void setGoodcomm(Integer goodcomm) {
		this.goodcomm = goodcomm;
	}
	public Integer getMidcomm() {
		return midcomm;
	}
	public void setMidcomm(Integer midcomm) {
		this.midcomm = midcomm;
	}
	public Integer getBadcomm() {
		return badcomm;
	}
	public void setBadcomm(Integer badcomm) {
		this.badcomm = badcomm;
	}
	public Integer getGoodlv() {
		return goodlv;
	}
	public void setGoodlv(Integer goodlv) {
		this.goodlv = goodlv;
	}
	@Override
	public String toString() {
		return "Commodity_Sell [monthSell=" + monthSell + ", allSell=" + allSell + ", allComm=" + allComm
				+ ", goodcomm=" + goodcomm + ", midcomm=" + midcomm + ", badcomm=" + badcomm + ", goodlv=" + goodlv
				+ "]";
	}
	
}
