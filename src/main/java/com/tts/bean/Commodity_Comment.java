package com.tts.bean;

import java.io.Serializable;

/**
 * Created by joe on 17/4/17.
 */
public class Commodity_Comment implements Serializable {

    private long commentId;
    private String content;
    private String type;
    private Users users;

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
        return "Commodity_Comment{" +
                "commentId=" + commentId +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", users=" + users +
                '}';
    }
}
