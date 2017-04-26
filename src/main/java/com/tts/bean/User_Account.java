package com.tts.bean;

import java.io.Serializable;

/**
 * 用户账户
 */
public class User_Account implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private long uaId;
    //账户余额
    private double uaMoney;

    public User_Account() {
    }

    @Override
    public String toString() {
        return "User_Account{" +
                "uaId=" + uaId +
                ", uaMoney=" + uaMoney +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getUaId() {
        return uaId;
    }

    public void setUaId(long uaId) {
        this.uaId = uaId;
    }

    public double getUaMoney() {
        return uaMoney;
    }

    public void setUaMoney(double uaMoney) {
        this.uaMoney = uaMoney;
    }

}
