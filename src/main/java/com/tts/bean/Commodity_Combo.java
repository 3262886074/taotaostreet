package com.tts.bean;

import java.io.Serializable;

/**
 * 商品套餐
 */
public class Commodity_Combo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private long ccid;
    private String ccname;   //套餐名
    private double price;

    public Commodity_Combo() {
    }

    @Override
    public String toString() {
        return "Commodity_Combo{" +
                "ccid=" + ccid +
                ", ccname='" + ccname + '\'' +
                ", price=" + price +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getCcid() {
        return ccid;
    }

    public void setCcid(long ccid) {
        this.ccid = ccid;
    }

    public String getCcname() {
        return ccname;
    }

    public void setCcname(String ccname) {
        this.ccname = ccname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
