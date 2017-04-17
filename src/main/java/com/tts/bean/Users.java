package com.tts.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 * Created by joe on 17/4/17.
 */
public class Users implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long uid;
    private String nickName;    //昵称
    private String upwd;		//密码
    private String uicon;		//头像
    private Integer sex;		//性别
    private Date birth;			//生日
    private long utel;			//电话
    private String email;		//邮箱
    private Date createTime;	//创建日期

    public Users() {
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUicon() {
        return uicon;
    }

    public void setUicon(String uicon) {
        this.uicon = uicon;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public long getUtel() {
        return utel;
    }

    public void setUtel(long utel) {
        this.utel = utel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", nickName='" + nickName + '\'' +
                ", upwd='" + upwd + '\'' +
                ", uicon='" + uicon + '\'' +
                ", sex=" + sex +
                ", birth=" + birth +
                ", utel=" + utel +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
