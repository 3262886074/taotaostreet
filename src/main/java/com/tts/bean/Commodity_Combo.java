package com.tts.bean;

import java.io.Serializable;

/**
 * Created by joe on 17/4/17.
 */
public class Commodity_Combo implements Serializable {

    private long ccid;
    private String ccname;
    private double price;
    private Commodity commodity;

    public Commodity_Combo() {
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

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    @Override
    public String toString() {
        return "Commodity_Combo{" +
                "ccid=" + ccid +
                ", ccname='" + ccname + '\'' +
                ", price=" + price +
                ", commodity=" + commodity +
                '}';
    }
}
