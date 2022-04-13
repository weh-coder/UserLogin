package com.weh.User;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//插入数据，以及对数据库驱动的开启
public class UserRegister {	//注册数据处理者
    Connection connection = null;
    PreparedStatement presql;   //预处理对象

    public UserRegister() throws SQLException {
        try {
            //连接mysql数据库
            MysqlDataSource mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setURL("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false");
            mysqlDataSource.setUser("root");
            mysqlDataSource.setPassword("123456");
            connection = mysqlDataSource.getConnection();
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null,"数据库连接失败","警告",JOptionPane.WARNING_MESSAGE);
        }
    }
    public void writeRegister(Register register){
        int flag;
        try {
            String sql = "INSERT INTO test.User VALUES (?,?,?)"; //插入语句
            presql = connection.prepareStatement(sql);
            presql.setString(1,register.getId());
            presql.setString(2,register.getPassword());
            presql.setString(3,register.getName());
            flag = presql.executeUpdate(); //成功插入式返回1
            //释放资源和空间
            connection.close();
            presql.close();
            if (flag!=0){
                JOptionPane.showMessageDialog(null,"注册成功");
            }else {
                JOptionPane.showMessageDialog(null,"注册失败","提示",JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"用户名已存在！","警告",JOptionPane.WARNING_MESSAGE);
        }
    }
}

