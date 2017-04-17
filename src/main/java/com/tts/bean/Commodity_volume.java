package com.tts.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by joe on 17/4/17.
 */
public class Commodity_volume implements Serializable {

    private long cvId;
    private Commodity commodity;
    private Users users;
    private Date createTime;

    public Commodity_volume() {
    }

    public long getCvId() {
        return cvId;
    }

    public void setCvId(long cvId) {
        this.cvId = cvId;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Commodity_volume{" +
                "cvId=" + cvId +
                ", commodity=" + commodity +
                ", users=" + users +
                ", createTime=" + createTime +
                '}';
    }
}
