package com.tts.bean;

/**
 * 商品类别
 */
public class Commodity_Category {

    private long ccid;
    private String cctype;

    public long getCcid() {
        return ccid;
    }

    public void setCcid(long ccid) {
        this.ccid = ccid;
    }

    public String getCctype() {
        return cctype;
    }

    public void setCctype(String cctype) {
        this.cctype = cctype;
    }

    @Override
    public String toString() {
        return "Commodity_Category{" +
                "ccid=" + ccid +
                ", cctype='" + cctype + '\'' +
                '}';
    }
}
