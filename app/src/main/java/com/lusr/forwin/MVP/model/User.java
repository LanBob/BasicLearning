package com.lusr.forwin.MVP.model;

/**
 * Modle层只跟Presenter层有连接
 */
public class User {
    private String userName;
    private String passWord;

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
