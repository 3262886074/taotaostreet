package com.tts.bean;

import java.io.Serializable;

/**
 * Created by joe on 17/4/17.
 */
public class Commodity_type implements Serializable {

    private long ct_id;
    private String typeName;
    private double price;
    private Commodity commodity;

    public Commodity_type() {
    }

    public long getCt_id() {
        return ct_id;
    }

    public void setCt_id(long ct_id) {
        this.ct_id = ct_id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
        return "Commodity_type{" +
                "ct_id=" + ct_id +
                ", typeName='" + typeName + '\'' +
                ", price=" + price +
                ", commodity=" + commodity +
                '}';
    }
}
