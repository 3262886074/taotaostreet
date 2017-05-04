package com.tts.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 商品产地
 * 
 * @author SYY
 *
 */
public class Site implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long sid;
	private String sname;
	private List<Commodity> commodity;

	@Override
	public String toString() {
		return "Site [sid=" + sid + ", sname=" + sname + ", commodity=" + commodity + "]";
	}

	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public List<Commodity> getCommodity() {
		return commodity;
	}

	public void setCommodity(List<Commodity> commodity) {
		this.commodity = commodity;
	}

}
