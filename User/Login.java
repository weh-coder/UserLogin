package com.weh.User;

//登录所需要的数据转入
public class Login {
    String id;
    String password;
    LoginDemo loginDemo;
    boolean loginSuccess = false;

    public LoginDemo getLoginDemo() {
        return loginDemo;
    }
    public void setLoginDemo(LoginDemo loginDemo) {
        this.loginDemo = loginDemo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoginSuccess() {
        return loginSuccess;
    }

    public void setLoginSuccess(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }
}