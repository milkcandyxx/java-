package www;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class denglu extends moban {
    public denglu() {

// 标题标签（居中显示）
        JLabel ab1=new JLabel("考试登陆系统");
        ab1.setBounds(250, 20, 200, 40); // 窗口宽600时居中[6](@ref)
        add(ab1);

// 用户名区域
        JLabel ab2=new JLabel("用户名：");
        ab2.setBounds(150, 100, 80, 20); // 左对齐[8](@ref)
        add(ab2);

        JTextField txt=new JTextField();
        txt.setBounds(240, 100, 200, 30); // 标签右侧+10间距[6](@ref)
        add(txt);

// 密码区域
        JLabel ab3=new JLabel("密码：");
        ab3.setBounds(150, 150, 80, 20); // 垂直间隔50[8](@ref)
        add(ab3);

        JPasswordField txt2=new JPasswordField();
        txt2.setBounds(240, 150, 200, 30);
        add(txt2);

// 按钮区域（水平居中）
        JButton bu = new JButton("登陆");
        bu.setBounds(100, 250, 100, 35); // 总宽300分三个按钮+间距[8](@ref)
        add(bu);
        bu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = null;
                String password= null;
                String nicheng= null;
                try (BufferedReader re = new BufferedReader(new FileReader("./name.txt"))) {
                    String line;
                    while ((line = re.readLine()) != null) {
                        String[] name = line.split(",");
                        username = name[1];
                        password = name[2];
                        nicheng = name[0];
                    }
                } catch (ArrayIndexOutOfBoundsException | IOException a) {
                    System.out.println("读取失败");
                }

                if (txt.getText().equals(username) && new String(txt2.getPassword()).equals(password)) {
                    JOptionPane.showMessageDialog(null, "你好"+nicheng+"\n"+"登录成功");

                    dispose();
                    new caidan();
                } else {
                    JOptionPane.showMessageDialog(null, "登录失败，usernam或password错误");
                }
            }
        });

        JButton bu2 = new JButton("注册");
        bu2.setBounds(250, 250, 100, 35); // 间隔50[6](@ref)
        add(bu2);
        bu2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new zhuce();
                dispose();
            }
        });

        JButton bu3 = new JButton("取消");
        bu3.setBounds(400, 250, 100, 35);
        add(bu3);
        bu3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args){
        new denglu();
    }
}