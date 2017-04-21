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
    private String cp_image_one;	//图片1
    private String cp_image_two;	//图片2
    private String cp_image_three;	//图片3
    private String cp_img;

    public Commodity_pics() {
    }

	public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCp_img() {
		return cp_img;
	}

	public void setCp_img(String cp_img) {
		this.cp_img = cp_img;
	}

	@Override
	public String toString() {
		return "Commodity_pics [cpId=" + cpId + ", cp_image_one=" + cp_image_one + ", cp_image_two=" + cp_image_two
				+ ", cp_image_three=" + cp_image_three + ", cp_img=" + cp_img + "]";
	}

	public long getCpId() {
        return cpId;
    }

    public void setCpId(long cpId) {
        this.cpId = cpId;
    }

    public String getCp_image_one() {
        return cp_image_one;
    }

    public void setCp_image_one(String cp_image_one) {
        this.cp_image_one = cp_image_one;
    }

    public String getCp_image_two() {
        return cp_image_two;
    }

    public void setCp_image_two(String cp_image_two) {
        this.cp_image_two = cp_image_two;
    }

    public String getCp_image_three() {
        return cp_image_three;
    }

    public void setCp_image_three(String cp_image_three) {
        this.cp_image_three = cp_image_three;
    }
}