package com.tts.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 商品销量/购买记录
 * TODO 重新设计
 */
public class Commodity_volume implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private long cvId;
    //创建时间
    private Date createTime;
    //一对多 商品
    private List<Commodity> commodities = new ArrayList<>();

    public Commodity_volume() {
    }

    @Override
    public String toString() {
        return "Commodity_volume{" +
                "cvId=" + cvId +
                ", createTime=" + createTime +
                ", commodities=" + commodities +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getCvId() {
        return cvId;
    }

    public void setCvId(long cvId) {
        this.cvId = cvId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Commodity> getCommodities() {
        return commodities;
    }

    public void setCommodities(List<Commodity> commodities) {
        this.commodities = commodities;
    }
}
