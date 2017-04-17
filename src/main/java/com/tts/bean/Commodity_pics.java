package com.tts.bean;

import java.io.Serializable;

/**
 * Created by joe on 17/4/17.
 */
public class Commodity_pics implements Serializable {

    private long coId;
    private String cp_image_one;
    private String cp_image_two;
    private String cp_image_three;
    private Commodity commodity;

    public Commodity_pics() {
    }

    public long getCoId() {
        return coId;
    }

    public void setCoId(long coId) {
        this.coId = coId;
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

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    @Override
    public String toString() {
        return "Commodity_pics{" +
                "coId=" + coId +
                ", cp_image_one='" + cp_image_one + '\'' +
                ", cp_image_two='" + cp_image_two + '\'' +
                ", cp_image_three='" + cp_image_three + '\'' +
                ", commodity=" + commodity +
                '}';
    }
}
