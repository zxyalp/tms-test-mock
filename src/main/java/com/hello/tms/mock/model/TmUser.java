package com.hello.tms.mock.model;

/**
 * @author alp.zxy
 * @date 2019/3/30
 */
public class TmUser {

    private Integer userId;
    private String userName;
    private String password;
    private String phone;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "{userId:"+userId+", username:"+userName+",password:"+password+", phone:"+phone+"}";
    }
}
