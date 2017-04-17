package com.tts.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品评价
 * Created by joe on 17/4/17.
 */
public class Commodity_Comment implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long commentId;	
    private String content;   //评价内容
    private String type;	  //评价类别
    private Users users;	  //用户
    private Commodity commodity; //商品
    private Date createDate; //创建时间
    
    public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Commodity_Comment() {
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

	@Override
	public String toString() {
		return "Commodity_Comment [commentId=" + commentId + ", content=" + content + ", type=" + type + ", users="
				+ users + ", commodity=" + commodity + ", createDate=" + createDate + "]";
	}


}
