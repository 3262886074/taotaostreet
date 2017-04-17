package com.tts.bean;

import java.io.Serializable;

/**
 * Created by joe on 17/4/17.
 */
public class Users_Authentication implements Serializable {

    private long uraId;
    private Users users;
    private String uraName;
    private long idcard;
    private String frontImage;
    private String backImage;

    public Users_Authentication() {
    }

    public long getUraId() {
        return uraId;
    }

    public void setUraId(long uraId) {
        this.uraId = uraId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
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

    @Override
    public String toString() {
        return "Users_Authentication{" +
                "uraId=" + uraId +
                ", users=" + users +
                ", uraName='" + uraName + '\'' +
                ", idcard=" + idcard +
                ", frontImage='" + frontImage + '\'' +
                ", backImage='" + backImage + '\'' +
                '}';
    }
}
