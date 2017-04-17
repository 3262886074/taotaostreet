package com.tts.bean;

import java.io.Serializable;

/**
 * 用户红包
 * Created by joe on 17/4/17.
 */
public class User_Red_package implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long urpId;
    private double money;  //红包金额
    private Users users;	//用户

    public User_Red_package() {
    }

    public long getUrpId() {
        return urpId;
    }

    public void setUrpId(long urpId) {
        this.urpId = urpId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "User_Red_package{" +
                "urpId=" + urpId +
                ", money=" + money +
                ", users=" + users +
                '}';
    }
}
