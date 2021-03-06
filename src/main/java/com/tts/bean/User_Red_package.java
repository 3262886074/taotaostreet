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
	private Integer status; //红包状态 0为未使用 1为已使用

	public User_Red_package() {
	}

	@Override
	public String toString() {
		return "User_Red_package{" +
				"urpId=" + urpId +
				", money=" + money +
				", status=" + status +
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
