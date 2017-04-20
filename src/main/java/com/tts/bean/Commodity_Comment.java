package com.tts.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 商品评价
 */
public class Commodity_Comment implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private long commentId;
    private String content;   //评价内容
    private String type;      //评价类别
    private Date createDate; //创建时间

    public Commodity_Comment() {
    }

    @Override
    public String toString() {
        return "Commodity_Comment{" +
                "commentId=" + commentId +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}