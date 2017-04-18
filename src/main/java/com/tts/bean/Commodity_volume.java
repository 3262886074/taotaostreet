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
    //购买用户
    private Users users;

}
