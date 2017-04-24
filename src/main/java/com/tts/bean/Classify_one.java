package com.tts.bean;

import java.util.List;

/**
 * 一级分类
 * 
 * @author SYY
 *
 */
public class Classify_one {
	private long cOneId;
	private String cOneName;
	private List<Classify_two> classifyTwo;

	@Override
	public String toString() {
		return "Classify_one [cOneId=" + cOneId + ", cOneName=" + cOneName + ", classifyTwo=" + classifyTwo + "]";
	}

	public long getcOneId() {
		return cOneId;
	}

	public void setcOneId(long cOneId) {
		this.cOneId = cOneId;
	}

	public String getcOneName() {
		return cOneName;
	}

	public void setcOneName(String cOneName) {
		this.cOneName = cOneName;
	}

	public List<Classify_two> getClassifyTwo() {
		return classifyTwo;
	}

	public void setClassifyTwo(List<Classify_two> classifyTwo) {
		this.classifyTwo = classifyTwo;
	}

}
