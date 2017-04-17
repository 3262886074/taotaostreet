package com.tts.bean;

import java.io.Serializable;

/**
 * 用户收藏
 * Created by joe on 17/4/17.
 */
public class User_Collect implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long ucId;	
    private Users users;	//用户
    private Commodity commodity;	//商品

    public User_Collect() {
    }

    public long getUcId() {
        return ucId;
    }

    public void setUcId(long ucId) {
        this.ucId = ucId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    @Override
    public String toString() {
        return "User_Collect{" +
                "ucId=" + ucId +
                ", users=" + users +
                ", commodity=" + commodity +
                '}';
    }
}
