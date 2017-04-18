package com.tts.bean;

import java.io.Serializable;

/**
 * 用户默认地址
 */
public class User_default_address implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long udaId;
	//用户地址 一对一
    private User_address user_address;

	public User_default_address() {
	}

	@Override
	public String toString() {
		return "User_default_address{" +
				"udaId=" + udaId +
				", user_address=" + user_address +
				'}';
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public long getUdaId() {
		return udaId;
	}

	public void setUdaId(long udaId) {
		this.udaId = udaId;
	}

	public User_address getUser_address() {
		return user_address;
	}

	public void setUser_address(User_address user_address) {
		this.user_address = user_address;
	}
}
