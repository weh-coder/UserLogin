package com.weh.User;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 *   注册窗口
 */
public class RegisterDemo extends JFrame {
    public RegisterDemo() {
        //获取显示屏的大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int sw = screenSize.width;
        int sh = screenSize.height;
        this.setTitle("HI注册界面");
        int width = 500;
        int height = 600;
        this.setBounds((sw - width) / 2, (sh - height) / 2, width, height);// 设置窗口的位置
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(RegisterDemo.class.getResource("/com/weh/img/chatping.jpg")));// 图标
        ImageIcon background = new ImageIcon(RegisterDemo.class.getResource("/com/weh/img/chat.gif")); // 背景图片
        JLabel label = new JLabel(background); // 把背景图片显示在一个标签里面
        label.setBounds(0, 0, this.getWidth(), this.getHeight()); // 把标签的大小位置设置为图片刚好填充整个面板
        JPanel imagePanel = (JPanel) this.getContentPane(); // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        imagePanel.setOpaque(false); // 窗口透明
        this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE)); // 把背景图片添加到分层窗格的最底层作为背景

        //盒子模块
        Box namebox = Box.createHorizontalBox();
        Box ubox = Box.createHorizontalBox();
        Box pbox = Box.createHorizontalBox();
        Box repbox = Box.createHorizontalBox();
        Box vbox = Box.createVerticalBox();

        JLabel nameLabel = new JLabel("用户名 :"); //文本设计
        nameLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));
        nameLabel.setForeground(new Color(0x02FFFF)); // 设置前景色
        JTextField nameField = new JTextField(); //输入框
        nameField.setFont(new Font("黑体", Font.BOLD, 15));
        nameField.setToolTipText("用户名");
        nameField.setColumns(15);


        JLabel uLabel = new JLabel("       HI :"); //文本设计
        uLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));
        uLabel.setForeground(new Color(0x02FFFF)); // 设置前景色
        JTextField uField = new JTextField(); //输入框
        uField.setFont(new Font("Arial", Font.BOLD, 15));
        uField.setToolTipText("HI");
        uField.setColumns(15);

        JLabel pLabel = new JLabel("密    码 :");    //文本设计
        pLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));
        pLabel.setForeground(new Color(0x02FFFF)); // 设置前景色
        JPasswordField pFd = new JPasswordField();
        pFd.setFont(new Font("Arial", Font.BOLD, 15));
        pFd.setToolTipText("密码");// 悬停显示
        pFd.setColumns(15);
        // 如果使用其他回显字符，可以设置大小，但是星星不可以。。。
        pFd.setEchoChar('●');// 星星符号


        JLabel RepLabel = new JLabel("确认密码:");    //文本设计
        RepLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));
        RepLabel.setForeground(new Color(0x02FFFF)); // 设置前景色
        JPasswordField RepFd = new JPasswordField();
        RepFd.setFont(new Font("Arial", Font.BOLD, 15));
        RepFd.setToolTipText("确认密码");// 悬停显示
        RepFd.setColumns(15);
        // 如果使用其他回显字符，可以设置大小，但是星星不可以。。。
        RepFd.setEchoChar('●');// 星星符号

        JButton button1 = new JButton("注册");    //登录按钮
        button1.setToolTipText("注册");// 悬停显示
        JButton button2 = new JButton("重置");    //重置按钮
        button2.setToolTipText("重置");// 悬停显示
        JMenu Menubutton3 = new JMenu("返回登录");    //重置按钮
        Menubutton3.setToolTipText("返回登录");// 悬停显示

        button1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button1.setForeground(Color.white); // 设置前景色
        button1.setBackground(new Color(0x08BDFD));
        button1.setDefaultCapable(true);
        button1.setBounds((this.getWidth() - 120 - 180) / 2, this.getHeight() - 150, 120, 30); // 设置按钮位置，及按钮大小
        button1.setCursor(new Cursor(Cursor.HAND_CURSOR));  //鼠标手势的设置

        button2.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button2.setForeground(Color.white); // 设置前景色
        button2.setBackground(new Color(0x08BDFD));
        button2.setDefaultCapable(true);
        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));//鼠标手势的设置
        button2.setBounds((this.getWidth() - 120 + 180) / 2, this.getHeight() - 150, 120, 30); // 设置按钮位置，及按钮大小

        Menubutton3.setFont(new Font("微软雅黑", Font.BOLD, 12));
        Menubutton3.setForeground(Color.white); // 设置前景色
        Menubutton3.setBackground(new Color(0x08BDFD));
        Menubutton3.setUI(new BasicButtonUI());  //恢复基本视觉效果
        Menubutton3.setBounds(5, this.getHeight() - 70, 85, 20); // 设置按钮位置，及按钮大小
        Menubutton3.setContentAreaFilled(false); // 设置按钮透明
        Menubutton3.setCursor(new Cursor(Cursor.HAND_CURSOR));

        /*
         分区模块布局
        */

        //小盒子，设计用户名模块
        namebox.add(nameLabel);
        namebox.add(Box.createHorizontalStrut(5));//插入中间盒子宽度为5，作为相邻文本的空隙
        namebox.add(nameField);

        ubox.add(uLabel);
        ubox.add(Box.createHorizontalStrut(5));//插入中间盒子宽度为5，作为相邻文本的空隙
        ubox.add(uField);
        //小盒子，设计密码模块
        pbox.add(pLabel);
        pbox.add(Box.createHorizontalStrut(5));
        pbox.add(pFd);

        repbox.add(RepLabel);
        repbox.add(Box.createHorizontalStrut(5));
        repbox.add(RepFd);

        vbox.add(Box.createVerticalStrut(90));//插入中间盒子高度为90，作为上下文本的空隙
        vbox.add(namebox);
        vbox.add(Box.createVerticalStrut(65));
        vbox.add(ubox);
        vbox.add(Box.createVerticalStrut(65));
        vbox.add(pbox);
        vbox.add(Box.createVerticalStrut(65));
        vbox.add(repbox);


        JPanel panel = new JPanel();
        panel.setUI(new BasicPanelUI());  //恢复基本视觉效果
        panel.setOpaque(false); // 面板透明
        panel.add(vbox, BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(button1);
        this.add(button2);
        this.add(Menubutton3);
        this.add(panel);
        this.setVisible(true);
        this.setResizable(false);

        //注册按钮监听
        button1.addActionListener(e -> {
            String pField = new String(pFd.getPassword());//转换
            String repField = new String(RepFd.getPassword());//转换
            try {
                if (nameField.getText().isEmpty() || pField.isEmpty() || repField.isEmpty()||uField.getText().isEmpty()) {
                    if (nameField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "用户名不能为空", "提示", JOptionPane.WARNING_MESSAGE);
                    } else if(uField.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "HI号不能为空", "提示", JOptionPane.WARNING_MESSAGE);
                    }
                    else if (pField.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "密码不能为空", "提示", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "确认密码不能为空", "提示", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    if (!pField.equals(repField)) {
                        JOptionPane.showMessageDialog(null, "两次密码不一致", "提示", JOptionPane.WARNING_MESSAGE);
                    } else {
                        String HI =uField.getText().trim();
                        String regex = "^\\d+$";
                        Pattern p =Pattern.compile(regex);
                        Matcher m = p.matcher(HI);
                        if(m.matches()){
                            init(nameField,uField, pFd);
                        }else{
                            JOptionPane.showMessageDialog(null, "HI号只能输入数字，请正确输入！", "警告", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "异常", "警告", JOptionPane.WARNING_MESSAGE);
            }
        });

        //重置按钮监听
        button2.addActionListener(e -> {
            nameField.setText(null);
            uField.setText(null);
            pFd.setText(null);
            RepFd.setText(null);
        });

        //返回登录窗口按钮监听
        Menubutton3.addActionListener(e -> {
            try {
                this.dispose();
                Thread.sleep(1000);
                new LoginDemo();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "异常", "警告", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public void init(JTextField nameField,JTextField uField, JPasswordField pFd) {
        Register register;
        UserRegister userRegister;
        try {
            register = new Register();
            register.setName(nameField.getText());
            register.setId(uField.getText());
            char[] p1 = pFd.getPassword();
            register.setPassword(new String(p1));
            userRegister = new UserRegister();
            userRegister.writeRegister(register);
            uField.setText(null);
           nameField.setText(null);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "异常", "警告", JOptionPane.WARNING_MESSAGE);
        }
    }
}

