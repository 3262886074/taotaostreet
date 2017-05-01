package com.tts.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 购物车
 */
public class Shopping_Cart implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private long scId;
    //商品条目 一对多
    private Set<Commodity_items> commodityItems = new HashSet<>();
    //用户 多对一
    private Users users;
    //创建时间
    private Date createTime;
    //购物车状态 -1为失效状态 0为生效状态
    private Integer status;

    public Shopping_Cart() {
    }


    @Override
    public String toString() {
        return "Shopping_Cart{" +
                "scId=" + scId +
                ", commodityItems=" + commodityItems +
                ", users=" + users +
                ", createTime=" + createTime +
                ", status=" + status +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getScId() {
        return scId;
    }

    public void setScId(long scId) {
        this.scId = scId;
    }


    public Set<Commodity_items> getCommodityItems() {
        return commodityItems;
    }


    public void setCommodityItems(Set<Commodity_items> commodityItems) {
        this.commodityItems = commodityItems;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
