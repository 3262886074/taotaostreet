package com.tts.bean;

import java.io.Serializable;

/**
 * 用户实名认证
 */
public class Users_Authentication implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long uraId;
    private String uraName;	//真实姓名
    private long idcard;	//身份证号
    private String frontImage;	//正面图
    private String backImage;	//背面图
    //双向一对一
    private Users users;

    public Users_Authentication() {
    }

    @Override
    public String toString() {
        return "Users_Authentication{" +
                "uraId=" + uraId +
                ", uraName='" + uraName + '\'' +
                ", idcard=" + idcard +
                ", frontImage='" + frontImage + '\'' +
                ", backImage='" + backImage + '\'' +
                ", users=" + users +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getUraId() {
        return uraId;
    }

    public void setUraId(long uraId) {
        this.uraId = uraId;
    }

    public String getUraName() {
        return uraName;
    }

    public void setUraName(String uraName) {
        this.uraName = uraName;
    }

    public long getIdcard() {
        return idcard;
    }

    public void setIdcard(long idcard) {
        this.idcard = idcard;
    }

    public String getFrontImage() {
        return frontImage;
    }

    public void setFrontImage(String frontImage) {
        this.frontImage = frontImage;
    }

    public String getBackImage() {
        return backImage;
    }

    public void setBackImage(String backImage) {
        this.backImage = backImage;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
