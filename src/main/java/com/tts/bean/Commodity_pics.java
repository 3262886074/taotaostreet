package com.tts.bean;

import java.io.Serializable;

/**
 * 商品图片
 */
public class Commodity_pics implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long cpId;
    private String cpImageOne;	//图片1
    private String cpImageTwo;	//图片2
    private String cpImageThree;	//图片3
    private String cpImg;

    public Commodity_pics() {
    }

    @Override
    public String toString() {
        return "Commodity_pics{" +
                "cpId=" + cpId +
                ", cpImageOne='" + cpImageOne + '\'' +
                ", cpImageTwo='" + cpImageTwo + '\'' +
                ", cpImageThree='" + cpImageThree + '\'' +
                ", cpImg='" + cpImg + '\'' +
                '}';
    }

    public long getCpId() {
        return cpId;
    }

    public void setCpId(long cpId) {
        this.cpId = cpId;
    }

    public String getCpImageOne() {
        return cpImageOne;
    }

    public void setCpImageOne(String cpImageOne) {
        this.cpImageOne = cpImageOne;
    }

    public String getCpImageTwo() {
        return cpImageTwo;
    }

    public void setCpImageTwo(String cpImageTwo) {
        this.cpImageTwo = cpImageTwo;
    }

    public String getCpImageThree() {
        return cpImageThree;
    }

    public void setCpImageThree(String cpImageThree) {
        this.cpImageThree = cpImageThree;
    }

    public String getCpImg() {
        return cpImg;
    }

    public void setCpImg(String cpImg) {
        this.cpImg = cpImg;
    }
}