package com.tts.bean;

import java.io.Serializable;

/**
 * 
 * 用户收货地址
 * Created by joe on 17/4/17.
 */
public class User_address implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long uaId;
    private String uaname;  //收货人
    private long uatel;		//收货电话
    private String location;//所在地
    private String address; //详细地址
    private Users users;	//用户

    public User_address() {
    }

    public long getUaId() {
        return uaId;
    }

    public void setUaId(long uaId) {
        this.uaId = uaId;
    }

    public String getUaname() {
        return uaname;
    }

    public void setUaname(String uaname) {
        this.uaname = uaname;
    }

    public long getUatel() {
        return uatel;
    }

    public void setUatel(long uatel) {
        this.uatel = uatel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "User_address{" +
                "uaId=" + uaId +
                ", uaname='" + uaname + '\'' +
                ", uatel=" + uatel +
                ", location='" + location + '\'' +
                ", address='" + address + '\'' +
                ", users=" + users +
                '}';
    }
}
