package com.weh.User;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
*   登录窗口
*/
public class LoginDemo extends JFrame {
    public LoginDemo() {
        super("HI登录界面");
        //获取显示屏的大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int sw = screenSize.width;
        int sh = screenSize.height;
        //窗口宽高大小
        int width = 500;
        int height = 340;
        this.setBounds((sw - width) / 2, (sh - height) / 2, width, height);//设置窗口的位置
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginDemo.class.getResource("/com/weh/img/chatping.jpg")));//窗口图标
        ImageIcon background = new ImageIcon(LoginDemo.class.getResource("/com/weh/img/chat.jpg")); //背景图片
        JLabel label = new JLabel(background); // 把背景图片显示在一个标签里面
        label.setBounds(0, 0, this.getWidth(), this.getHeight()); // 把标签的大小位置设置为图片刚好填充整个面板
        JPanel imagePanel = (JPanel) this.getContentPane(); // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        imagePanel.setOpaque(false); // 窗口透明
        this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE)); // 把背景图片添加到分层窗格的最底层作为背景

        JPanel panel = new JPanel();
        //盒子模块
        Box ubox = Box.createHorizontalBox();
        Box pbox = Box.createHorizontalBox();
        Box vbox = Box.createVerticalBox();

        //创建界面工具类
        JLabel uLabel = new JLabel("   HI :"); //文本设计
        uLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        uLabel.setForeground(new Color(0xFBFCFD)); // 设置前景色
        JTextField uField = new JTextField(); //输入框
        uField.setFont(new Font("Arial", Font.BOLD, 15));
        uField.setToolTipText("HI");// 悬停显示
        uField.setColumns(12);

        JLabel pLabel = new JLabel("密  码:");    //文本设计
        pLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        pLabel.setForeground(new Color(0xFBFCFD)); // 设置前景色
        JPasswordField pFd = new JPasswordField();
        pFd.setFont(new Font("Arial", Font.BOLD, 15));
        pFd.setToolTipText("密码");// 悬停显示
        pFd.setColumns(12);
        // 如果使用其他回显字符，可以设置大小，但是星星不可以。。。
        pFd.setEchoChar('●');// 星星符号

        JButton button1 = new JButton("登录");    //登录按钮
        button1.setToolTipText("登录");// 悬停显示
        JButton button2 = new JButton("重置");    //重置按钮
        button2.setToolTipText("重置");// 悬停显示
        JMenu Menubutton3 = new JMenu("注册账号");    //重置按钮
        Menubutton3.setToolTipText("注册账号");// 悬停显示
        // 字体设置
        button1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button1.setForeground(Color.white); // 设置前景色
        button1.setBackground(new Color(0x08BDFD));
        button1.setDefaultCapable(true);
        button1.setBounds((this.getWidth() - 120 - 180) / 2, 250, 120, 30); // 设置按钮位置，及按钮大小
        button1.setCursor(new Cursor(Cursor.HAND_CURSOR));  //鼠标手势的设置

        button2.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button2.setForeground(Color.white); // 设置前景色
        button2.setBackground(new Color(0x08BDFD));
        button2.setDefaultCapable(true);
        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));//鼠标手势的设置
        button2.setBounds((this.getWidth() - 120 + 180) / 2, 250, 120, 30); // 设置按钮位置，及按钮大小

        Menubutton3.setFont(new Font("微软雅黑", Font.BOLD, 12));
        Menubutton3.setForeground(new Color(0x02FCFC)); // 设置前景色
        Menubutton3.setUI(new BasicButtonUI());  //恢复基本视觉效果
        Menubutton3.setBounds(5, 280, 85, 20); // 设置按钮位置，及按钮大小
        Menubutton3.setContentAreaFilled(false); // 设置按钮透明
        Menubutton3.setCursor(new Cursor(Cursor.HAND_CURSOR));

        /*
         分区模块布局
        */
        //小盒子，设计用户名布局模块
        ubox.add(uLabel);
        ubox.add(Box.createHorizontalStrut(5));//插入中间盒子宽度为5，作为相邻文本的空隙
        ubox.add(uField);
        //小盒子，设计密码框布局模块
        pbox.add(pLabel);
        pbox.add(Box.createHorizontalStrut(5));//插入中间盒子宽度为5，作为相邻文本的空隙
        pbox.add(pFd);

        //大盒子
        vbox.add(Box.createVerticalStrut(80));//插入中间盒子高度为80，作为上下文本的空隙
        vbox.add(ubox);
        vbox.add(Box.createVerticalStrut(60));//插入中间盒子高度为60，作为上下文本的空隙
        vbox.add(pbox);


        uField.setText("3037502828");   //设置默认账号
        pFd.setText("123456");  //设置默认密码
        panel.setUI(new BasicPanelUI());  //恢复基本视觉效果
        panel.setOpaque(false); // 面板透明
        panel.add(vbox, BorderLayout.CENTER);//vbox盒子居中
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(button1);
        this.add(button2);
        this.add(Menubutton3);
        this.add(panel);
        this.setVisible(true);
        this.setResizable(false);

        //点击按钮的监听事件
        button1.addActionListener(e -> {    //登录按钮监听事件
            try {
                //正则法则，验证输入数据的字符是否都是数字
                String HI =uField.getText().trim();
                String regex = "^\\d+$";
                Pattern p =Pattern.compile(regex);
                Matcher m = p.matcher(HI);
                if(m.matches()){//匹配成功，则传入输入的数据
                    init(this,uField, pFd);
                }else {
                    JOptionPane.showMessageDialog(null, "只能输入数字，请正确输入！", "警告", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "异常", "警告", JOptionPane.WARNING_MESSAGE);
            }
        });
        button2.addActionListener(e -> {//重置按钮监听事件
            uField.setText("");
            pFd.setText("");
        });
        Menubutton3.addActionListener(e -> {//跳转到注册窗口按钮监听事件
            try {
                this.dispose();
                Thread.sleep(1000);
                new RegisterDemo();
            } catch (InterruptedException interruptedException) {
                JOptionPane.showMessageDialog(null, "异常", "警告", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public void init(LoginDemo loginDemo,JTextField uField, JPasswordField pFd) {
        Login login;
        UserLogin UserLogin;
        try {
            login=new Login();
            login.setLoginDemo(loginDemo);
            login.setId(uField.getText());
            char[] p = pFd.getPassword();
            login.setPassword(new String(p));
            UserLogin = new UserLogin();
            UserLogin.readLogin(login);
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "异常", "警告", JOptionPane.WARNING_MESSAGE);
        }

    }
}
