package com.tts.bean;

import java.io.Serializable;

/**
 * 用户红包
 */
public class User_Red_package implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long urpId;
    private double money;  //红包金额

	public User_Red_package() {
	}

	@Override
	public String toString() {
		return "User_Red_package{" +
				"urpId=" + urpId +
				", money=" + money +
				'}';
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
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
}
