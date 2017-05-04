package com.tts.bean;

import java.io.Serializable;
import java.util.List;

public class Paging_Commodity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long sumPage;// 总行数
	private String parameter;// 查询参数

	private List<Commodity> commodity;// 查询的商品
	private List<Brand> brand;// 查询品牌
	private List<Site> site;// 查询产地

	@Override
	public String toString() {
		return "Paging_Commodity [sumPage=" + sumPage + ", parameter=" + parameter + ", commodity=" + commodity
				+ ", brand=" + brand + ", site=" + site + "]";
	}

	public long getSumPage() {
		return sumPage;
	}

	public void setSumPage(long sumPage) {
		this.sumPage = sumPage;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public List<Commodity> getCommodity() {
		return commodity;
	}

	public void setCommodity(List<Commodity> commodity) {
		this.commodity = commodity;
	}

	public List<Brand> getBrand() {
		return brand;
	}

	public void setBrand(List<Brand> brand) {
		this.brand = brand;
	}

	public List<Site> getSite() {
		return site;
	}

	public void setSite(List<Site> site) {
		this.site = site;
	}

}
