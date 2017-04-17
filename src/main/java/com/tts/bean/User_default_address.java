package com.tts.bean;

import java.io.Serializable;

/**
 * 用户默认地址
 * Created by joe on 17/4/17.
 */
public class User_default_address implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long udaId;
    private Users users;  //用户
    private User_address user_address;	//用户地址

    public User_default_address() {
    }

    public long getUdaId() {
        return udaId;
    }

    public void setUdaId(long udaId) {
        this.udaId = udaId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public User_address getUser_address() {
        return user_address;
    }

    public void setUser_address(User_address user_address) {
        this.user_address = user_address;
    }

    @Override
    public String toString() {
        return "User_default_address{" +
                "udaId=" + udaId +
                ", users=" + users +
                ", user_address=" + user_address +
                '}';
    }
}
