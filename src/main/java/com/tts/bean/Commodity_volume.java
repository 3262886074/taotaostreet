package com.tts.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品销量
 * Created by joe on 17/4/17.
 */
public class Commodity_volume implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long cvId;
    private Commodity commodity; //商品
    private Users users;	//购买用户
    private Date createTime;	//创建时间

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
