package com.tts.bean;

import java.util.List;

/**
 * 三级分类
 * 
 * @author SYY
 *
 */
public class Classify_three {
	
	private long cThreeId;
	private String cThreeName;
	private List<Commodity> commodity;//商品类

	@Override
	public String toString() {
		return "Classify_three [cThreeId=" + cThreeId + ", cThreeName=" + cThreeName + ", commodity=" + commodity + "]";
	}

	public long getcThreeId() {
		return cThreeId;
	}

	public void setcThreeId(long cThreeId) {
		this.cThreeId = cThreeId;
	}

	public String getcThreeName() {
		return cThreeName;
	}

	public void setcThreeName(String cThreeName) {
		this.cThreeName = cThreeName;
	}

	public List<Commodity> getCommodity() {
		return commodity;
	}

	public void setCommodity(List<Commodity> commodity) {
		this.commodity = commodity;
	}

}
