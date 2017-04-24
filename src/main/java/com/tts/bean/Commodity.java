package com.tts.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 商品表
 */
public class Commodity implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private long cid;
	private String cname; // 商品名
	private double price; // 商品原价格 不含套餐
	private Integer postage; // 商品运费
	private double forSalePrice; // 打折价
	private Integer number; // 库存
	private String details; // 产品参数
	// 一对多 套餐
	private Set<Commodity_Combo> combos = new HashSet<>();
	// 一对多 类型
	private Set<Commodity_type> commodityTypes = new HashSet<>();
	// 一对多 评论
	private Set<Commodity_Comment> comments = new HashSet<>();
	// 一对一商品图
	private Commodity_pics commodityPics;
	// 商品类别 一对多
	private Set<Commodity_Category> commodityCategories = new HashSet<>();
	// 商品销量 一对一
	private Commodity_Sell commoditySell;

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Commodity() {
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getPostage() {
		return postage;
	}

	public void setPostage(Integer postage) {
		this.postage = postage;
	}

	public double getForSalePrice() {
		return forSalePrice;
	}

	public void setForSalePrice(double forSalePrice) {
		this.forSalePrice = forSalePrice;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Set<Commodity_Combo> getCombos() {
		return combos;
	}

	public void setCombos(Set<Commodity_Combo> combos) {
		this.combos = combos;
	}

	public Set<Commodity_type> getCommodityTypes() {
		return commodityTypes;
	}

	public void setCommodityTypes(Set<Commodity_type> commodityTypes) {
		this.commodityTypes = commodityTypes;
	}

	public Set<Commodity_Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Commodity_Comment> comments) {
		this.comments = comments;
	}

	public Commodity_pics getCommodityPics() {
		return commodityPics;
	}

	public void setCommodityPics(Commodity_pics commodityPics) {
		this.commodityPics = commodityPics;
	}

	public Set<Commodity_Category> getCommodityCategories() {
		return commodityCategories;
	}

	public void setCommodityCategories(Set<Commodity_Category> commodityCategories) {
		this.commodityCategories = commodityCategories;
	}

	public Commodity_Sell getCommoditySell() {
		return commoditySell;
	}

	public void setCommoditySell(Commodity_Sell commoditySell) {
		this.commoditySell = commoditySell;
	}

	@Override
	public String toString() {
		return "Commodity [cid=" + cid + ", cname=" + cname + ", price=" + price + ", postage=" + postage
				+ ", forSalePrice=" + forSalePrice + ", number=" + number + ", details=" + details + ", combos="
				+ combos + ", commodityTypes=" + commodityTypes + ", comments=" + comments + ", commodityPics="
				+ commodityPics + ", commodityCategories=" + commodityCategories + ", commoditySell=" + commoditySell
				+ "]";
	}
}
