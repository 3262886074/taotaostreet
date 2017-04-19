package com.tts.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户
 */
public class Users implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private long uid;
    private String nickName;    //昵称
    private String upwd;        //密码
    private String uicon;        //头像
    private Integer sex;        //性别
    private Date birth;            //生日
    private long utel;            //电话
    private String email;        //邮箱
    private Date createTime;    //创建日期
    //用户账户 一对一
    private User_Account userAccount;
    //用户地址 一对多
    private Set<User_address> userAddresses = new HashSet<>();
    //用户收藏 一对多
    private Set<User_Collect> userCollects = new HashSet<>();
    //红包 一对多
    private Set<User_Red_package> userRedPackages = new HashSet<>();
    //账户安全问题 双向一对一
    private User_Safety_Question user_safety_question;
    //账户认证 双向一对一
    private Users_Authentication users_authentication;
    //订单 一对多
    private Set<Order> orders = new HashSet<>();
    //优惠券 一对多
    private Set<Discount_coupon> discountCoupons = new HashSet<>();

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", nickName='" + nickName + '\'' +
                ", upwd='" + upwd + '\'' +
                ", uicon='" + uicon + '\'' +
                ", sex=" + sex +
                ", birth=" + birth +
                ", utel=" + utel +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", userAccount=" + userAccount +
                ", userAddresses=" + userAddresses +
                ", userCollects=" + userCollects +
                ", userRedPackages=" + userRedPackages +
                ", user_safety_question=" + user_safety_question +
                ", users_authentication=" + users_authentication +
                ", orders=" + orders +
                ", discountCoupons=" + discountCoupons +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUicon() {
        return uicon;
    }

    public void setUicon(String uicon) {
        this.uicon = uicon;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public long getUtel() {
        return utel;
    }

    public void setUtel(long utel) {
        this.utel = utel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User_Account getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(User_Account userAccount) {
        this.userAccount = userAccount;
    }

    public Set<User_address> getUserAddresses() {
        return userAddresses;
    }

    public void setUserAddresses(Set<User_address> userAddresses) {
        this.userAddresses = userAddresses;
    }

    public Set<User_Collect> getUserCollects() {
        return userCollects;
    }

    public void setUserCollects(Set<User_Collect> userCollects) {
        this.userCollects = userCollects;
    }

    public Set<User_Red_package> getUserRedPackages() {
        return userRedPackages;
    }

    public void setUserRedPackages(Set<User_Red_package> userRedPackages) {
        this.userRedPackages = userRedPackages;
    }

    public User_Safety_Question getUser_safety_question() {
        return user_safety_question;
    }

    public void setUser_safety_question(User_Safety_Question user_safety_question) {
        this.user_safety_question = user_safety_question;
    }

    public Users_Authentication getUsers_authentication() {
        return users_authentication;
    }

    public void setUsers_authentication(Users_Authentication users_authentication) {
        this.users_authentication = users_authentication;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Discount_coupon> getDiscountCoupons() {
        return discountCoupons;
    }

    public void setDiscountCoupons(Set<Discount_coupon> discountCoupons) {
        this.discountCoupons = discountCoupons;
    }
}
