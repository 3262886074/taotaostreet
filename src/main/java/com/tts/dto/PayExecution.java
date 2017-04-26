package com.tts.dto;

import com.tts.bean.User_address;

/**
 * Created by joe on 17/4/25.
 * 执行支付
 */
public class PayExecution {

    private double money;

    private User_address userAddress;

    private String stateInfo;

    public PayExecution() {
    }

    public PayExecution(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public PayExecution(double money, User_address userAddress, String stateInfo) {
        this.money = money;
        this.userAddress = userAddress;
        this.stateInfo = stateInfo;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public User_address getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(User_address userAddress) {
        this.userAddress = userAddress;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    @Override
    public String toString() {
        return "PayExecution{" +
                "money=" + money +
                ", userAddress=" + userAddress +
                ", stateInfo='" + stateInfo + '\'' +
                '}';
    }
}
