package com.tts.bean;

import java.util.List;
/**
 * 二级分类
 * @author SYY
 *
 */
public class Classify_two {
	private long cTwoId;
	private String cTwoName;
	private List<Classify_three> classifyThree;
	@Override
	public String toString() {
		return "Classify_two [cTwoId=" + cTwoId + ", cTwoName=" + cTwoName + ", classifyThree=" + classifyThree + "]";
	}

	public long getcTwoId() {
		return cTwoId;
	}
	public void setcTwoId(long cTwoId) {
		this.cTwoId = cTwoId;
	}
	public String getcTwoName() {
		return cTwoName;
	}
	public void setcTwoName(String cTwoName) {
		this.cTwoName = cTwoName;
	}
	public List<Classify_three> getClassifyThree() {
		return classifyThree;
	}
	public void setClassifyThree(List<Classify_three> classifyThree) {
		this.classifyThree = classifyThree;
	}

}
