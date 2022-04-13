package com.weh.User;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//匹配输入的登录数据，以及对数据库驱动的开启
public class UserLogin {
    Connection connection = null;
    PreparedStatement prepare;
    ResultSet resultSet;
    boolean loginSuccess;

    public UserLogin() throws SQLException, ClassNotFoundException {
        //连接mysql数据库
        try {
            MysqlDataSource mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setURL("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false");//本地IP:端口/数据库名
            mysqlDataSource.setUser("root");//mysql数据库的用户名
            mysqlDataSource.setPassword("123456");//密码
            connection = mysqlDataSource.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "数据库连接失败", "提示", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void readLogin(Login login) {
        try {
            String sql = "SELECT * FROM test.User WHERE UserID = ? AND  UserPassword = ?";//查询语句
            prepare = connection.prepareStatement(sql);//创建执行环境
            prepare.setString(1, login.getId());
            prepare.setString(2, login.getPassword());
            resultSet = prepare.executeQuery();//执行查询语句,如数据匹配成功，则返回true
            if (resultSet.next()) { //迭代查询
                login.setLoginSuccess(true);
                JOptionPane.showMessageDialog(null, "登录成功");
            } else {
                    login.setLoginSuccess(false);
                    if (login.getId().isEmpty() || login.getPassword().isEmpty()) {
                        if (login.getId().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "用户名不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
                        }
                        if (login.getPassword().isEmpty()){
                            JOptionPane.showMessageDialog(null, "密码不能为空！","提示", JOptionPane.WARNING_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "用户名不存在！", "警告", JOptionPane.ERROR_MESSAGE);
                    }
                }
                //释放资源和空间
                connection.close();
                prepare.close();
                resultSet.close();
                loginSuccess = login.isLoginSuccess();
            } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "异常", "警告", JOptionPane.ERROR_MESSAGE);
        }

    }
}

