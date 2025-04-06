package week7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import week7.*;

// 定义一个名为 denglu 的类，继承自 JFrame 类，用于创建一个登录窗口
public class denglu extends JFrame {
    // 类的构造函数，用于初始化窗口及其组件
    public denglu() {
        // 调用父类 JFrame 的构造函数，设置窗口的标题为 "考试系统"
        super("考试系统");
        // 设置窗口的大小为 600 像素宽，400 像素高
        setSize(600, 400);
        // 设置窗口关闭时的操作，当关闭窗口时，程序退出
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // 设置窗口的布局管理器为绝对布局，即可以通过坐标精确放置组件
        setLayout(null);
        // 将窗口放置在屏幕中央
        setLocationRelativeTo(null);
        // 设置窗口大小不可更改
        setResizable(false);
        // 设置窗口为可见状态，即显示窗口
        setVisible(true);

        // 创建一个 JLabel 组件，用于显示标题 "考试登陆系统"
        JLabel ab1 = new JLabel("登录");
        // 设置标题标签的位置和大小，使其在窗口宽度为 600 像素时居中显示
        ab1.setBounds(250, 20, 200, 40);
        // 将标题标签添加到窗口中
        add(ab1);

        // 创建一个 JLabel 组件，用于显示 "用户名：" 提示信息
        JLabel ab2 = new JLabel("用户名：");
        // 设置用户名标签的位置和大小，使其左对齐
        ab2.setBounds(150, 100, 80, 20);
        // 将用户名标签添加到窗口中
        add(ab2);

        // 创建一个 JTextField 组件，用于用户输入用户名
        JTextField txt = new JTextField();
        // 设置文本框的位置和大小，使其位于用户名标签的右侧，且有 10 像素的间距
        txt.setBounds(240, 100, 200, 30);
        // 将文本框添加到窗口中
        add(txt);

        // 创建一个 JLabel 组件，用于显示 "密码：" 提示信息
        JLabel ab3 = new JLabel("密码：");
        // 设置密码标签的位置和大小，使其与用户名标签垂直间隔 50 像素
        ab3.setBounds(150, 150, 80, 20);
        // 将密码标签添加到窗口中
        add(ab3);

        // 创建一个 JPasswordField 组件，用于用户输入密码
        JPasswordField txt2 = new JPasswordField();
        // 设置密码框的位置和大小
        txt2.setBounds(240, 150, 200, 30);
        // 将密码框添加到窗口中
        add(txt2);

        // 创建一个 JButton 组件，用于实现登录功能
        JButton bu = new JButton("登陆");
        // 设置登录按钮的位置和大小，总宽度为 300 像素，三个按钮加上间距平均分布
        bu.setBounds(100, 250, 100, 35);
        // 将登录按钮添加到窗口中
        add(bu);
        // 为登录按钮添加一个动作监听器，当按钮被点击时触发相应的操作
        bu.addActionListener(new ActionListener() {
            // 当按钮被点击时，会调用 actionPerformed 方法
            public void actionPerformed(ActionEvent e) {
                // 获取用户输入的用户名和密码，并进行比较
                if (txt.getText().equals("1") && new String(txt2.getPassword()).equals("1")) {
                    // 如果用户名和密码都为 "1"，则弹出一个消息对话框，显示登录成功
                    JOptionPane.showMessageDialog(null, "登录成功");
                } else {
                    // 如果用户名或密码不正确，弹出一个消息对话框，显示登录失败
                    JOptionPane.showMessageDialog(null, "登录失败，usernam或password错误");
                }
            }
        });

        // 创建一个 JButton 组件，用于实现注册功能
        JButton bu2 = new JButton("注册");
        // 设置注册按钮的位置和大小，与登录按钮间隔 50 像素
        bu2.setBounds(250, 250, 100, 35);
        // 将注册按钮添加到窗口中
        add(bu2);
        // 为注册按钮添加一个动作监听器，当按钮被点击时触发相应的操作
        bu2.addActionListener(new ActionListener() {
            // 当按钮被点击时，会调用 actionPerformed 方法
            public void actionPerformed(ActionEvent e) {
                // 关闭当前的登录窗口
                denglu.this.dispose();
                // 创建一个新的注册窗口实例
                new zhuce();
            }
        });

        // 创建一个 JButton 组件，用于实现取消功能
        JButton bu3 = new JButton("取消");
        // 设置取消按钮的位置和大小
        bu3.setBounds(400, 250, 100, 35);
        // 将取消按钮添加到窗口中
        add(bu3);


    }

    // 程序的入口点，当程序启动时会首先执行 main 方法
    public static void main(String[] args) {
        // 创建一个 denglu 类的实例，即显示登录窗口
        new denglu();
    }
}