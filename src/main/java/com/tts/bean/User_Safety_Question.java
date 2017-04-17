package com.tts.bean;

import java.io.Serializable;

/**
 * Created by joe on 17/4/17.
 */
public class User_Safety_Question implements Serializable {

    private long usqId;
    private String questionOne;
    private String answerOne;
    private String questionTwo;
    private String answerTwo;
    private Users users;

    public User_Safety_Question() {
    }

    public long getUsqId() {
        return usqId;
    }

    public void setUsqId(long usqId) {
        this.usqId = usqId;
    }

    public String getQuestionOne() {
        return questionOne;
    }

    public void setQuestionOne(String questionOne) {
        this.questionOne = questionOne;
    }

    public String getAnswerOne() {
        return answerOne;
    }

    public void setAnswerOne(String answerOne) {
        this.answerOne = answerOne;
    }

    public String getQuestionTwo() {
        return questionTwo;
    }

    public void setQuestionTwo(String questionTwo) {
        this.questionTwo = questionTwo;
    }

    public String getAnswerTwo() {
        return answerTwo;
    }

    public void setAnswerTwo(String answerTwo) {
        this.answerTwo = answerTwo;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "User_Safety_Question{" +
                "usqId=" + usqId +
                ", questionOne='" + questionOne + '\'' +
                ", answerOne='" + answerOne + '\'' +
                ", questionTwo='" + questionTwo + '\'' +
                ", answerTwo='" + answerTwo + '\'' +
                ", users=" + users +
                '}';
    }
}
