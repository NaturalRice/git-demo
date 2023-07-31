package com.itheima.ui;

import com.itheima.domain.User;
import com.itheima.util.CodeUtil;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class RegisterJFrame extends JFrame implements MouseListener {
    //跟注册相关的代码都写在这里
    public static ArrayList<User> allUsers = new ArrayList<>();
    static {//这里是两个现有的用户
        allUsers.add(new User("zhangsan","123"));
        allUsers.add(new User("lisi","1234"));
    }

    public static ArrayList<User> getMyStaticList() {//用于允许登录界面访问已注册用户的集合
        return allUsers;
    }

    JButton register = new JButton();

    JButton reset = new JButton();

    JTextField username = new JTextField();

    JPasswordField password = new JPasswordField();

    JPasswordField passwordAgain = new JPasswordField();

    //利用空参构造先创建用户对象
    User s = new User();


    public RegisterJFrame(){
        //初始化界面
        initJFrame();

        //在这个界面中添加内容
        initView();

        //让当前界面显示出来
        this.setVisible(true);
    }

    public void initView(){
        //1. 添加注册用户名文字
        JLabel usernameText = new JLabel(new ImageIcon("..\\puzzlegame\\image\\register\\注册用户名.png"));
        usernameText.setBounds(97, 134, 93, 17);
        this.getContentPane().add(usernameText);

        //2.添加注册用户名输入框
        username.setBounds(195, 130, 200, 30);
        this.getContentPane().add(username);

        //3.添加注册密码文字
        JLabel passwordText = new JLabel(new ImageIcon("..\\puzzlegame\\image\\register\\注册密码.png"));
        passwordText.setBounds(120, 199, 64, 16);
        this.getContentPane().add(passwordText);

        //4.注册密码输入框
        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

        //5.添加再次输入密码文字
        JLabel passwordAgainText = new JLabel(new ImageIcon("..\\puzzlegame\\image\\register\\再次输入密码.png"));
        passwordAgainText.setBounds(87, 255, 100, 30);
        this.getContentPane().add(passwordAgainText);

        //6.再次输入密码输入框
        passwordAgain.setBounds(195, 256, 200, 30);
        this.getContentPane().add(passwordAgain);


        //7.添加注册按钮
        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("..\\puzzlegame\\image\\register\\注册按钮.png"));
        //去除按钮的边框
        register.setBorderPainted(false);
        //去除按钮的背景
        register.setContentAreaFilled(false);
        //给注册按钮绑定鼠标事件
        register.addMouseListener(this);
        this.getContentPane().add(register);

        //8.添加注册按钮
        reset.setBounds(123, 310, 128, 47);
        reset.setIcon(new ImageIcon("..\\puzzlegame\\image\\register\\重置按钮.png"));
        //去除按钮的边框
        reset.setBorderPainted(false);
        //去除按钮的背景
        reset.setContentAreaFilled(false);
        //给注册按钮绑定鼠标事件
        reset.addMouseListener(this);
        this.getContentPane().add(reset);


        //9.添加背景图片
        JLabel background = new JLabel(new ImageIcon("..\\puzzlegame\\image\\register\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);

    }




    public void initJFrame() {
        this.setSize(488,500);//设置界面宽高
        this.setTitle("拼图 注册");//设置界面标题
        this.setAlwaysOnTop(true);//设置界面置顶
        this.setLocationRelativeTo(null);//设置界面居中
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置关闭模式(模式3:只要其中一个按X后，整个虚拟机全部结束，停止运行程序）
        this.setLayout(null);//取消内部默认布局
    }


    //点击
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == register){
            System.out.println("点击了注册按钮");
            //获取三个文本输入框中的内容
            String usernameInput = username.getText();
            String passwordInput = password.getText();
            String passwordAgainInput = passwordAgain.getText();

            //创建一个User对象（这里的对象必须是2个变量，否则底下contains函数返回的是空值会报错，改了半天了）
            User userInfo = new User(usernameInput, passwordInput);
            System.out.println("用户输入的用户名为" + usernameInput);
            System.out.println("用户输入的密码为" + passwordInput);
            System.out.println("用户再次输入的密码为" + passwordAgainInput);

            if(usernameInput.length() == 0 || passwordInput.length() == 0 || passwordAgainInput.length() == 0){
                //校验用户名和密码是否为空
                System.out.println("用户名或者密码为空");
                //调用showJDialog方法并展示弹框
                showJDialog("空空如也~");
            }else if(!passwordInput.equals(passwordAgainInput)){
                //校验两次输入的密码是否一样
                System.out.println("两次输入的密码不一样");
                //调用showJDialog方法并展示弹框
                showJDialog("你在赣神魔 (>-<) ");
            }else if(!contains(userInfo)){
                System.out.println("用户名和密码输入完毕可以登录了");


                s.setUsername(usernameInput);
                s.setPassword(passwordInput);
                //把用户对象添加到集合中
                allUsers.add(s);
                System.out.println();
                //打印出所有用户与密码
                System.out.println("用户\t密码");
                //当代码执行到这里，表示集合中是有数据的
                for( int i = 0; i < allUsers.size(); i++ ){
                    User stu = allUsers.get(i);
                    System.out.println(stu.getUsername() + "\t\t" + stu.getPassword());
                }


                //关闭当前注册界面
                this.setVisible(false);
                //需要把当前注册的用户名传递给登录界面
                new LoginJFrame();
            }else{
                System.out.println("用户名已存在");
                showJDialog("你已经注册了，你个憨批...");
            }
        }else if(e.getSource() == reset){
            System.out.println("点击了重置按钮");
            //关闭当前注册界面再打开界面，相当于重新加载一遍
            this.setVisible(false);
            new RegisterJFrame();
        }
    }


    public void showJDialog(String content){
        //创建一个弹框对象
        JDialog jDialog = new JDialog();
        //给弹框设置大小
        jDialog.setSize(200, 150);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭永远无法操作下面的界面
        jDialog.setModal(true);

        //创建Jlabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);

        //让弹框展示出来
        jDialog.setVisible(true);
    }

    //按下不松
    @Override
    public void mousePressed(MouseEvent e){
        if (e.getSource() == register) {
            register.setIcon(new ImageIcon("..\\puzzlegame\\image\\register\\注册按下.png"));
        } else if (e.getSource() == reset) {
            reset.setIcon(new ImageIcon("..\\puzzlegame\\image\\register\\重置按下.png"));
        }
    }

    //松开按钮
    @Override
    public void mouseReleased(MouseEvent e){
        if (e.getSource() == register) {
            register.setIcon(new ImageIcon("..\\puzzlegame\\image\\register\\注册按钮.png"));
        } else if (e.getSource() == reset) {
            reset.setIcon(new ImageIcon("..\\puzzlegame\\image\\register\\重置按钮.png"));
        }
    }

    //鼠标划入
    @Override
    public void mouseEntered(MouseEvent e){

    }

    //鼠标划出
    @Override
    public void mouseExited(MouseEvent e){

    }

    //判断用户在集合中是否存在
    public boolean contains(User userInput){
        for (int i = 0; i < allUsers.size(); i++) {
            User rightUser = allUsers.get(i);
            if(userInput.getUsername().equals(rightUser.getUsername())){
                //有相同的代表存在，后面的不需要比
                return true;
            }
        }
        //循环结束之后还没有找到就表示不存在
        return false;
    }

}
