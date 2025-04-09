package www;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class zhuce extends moban {
    public zhuce() {

        // 标题标签（居中显示）
        JLabel ab1 = new JLabel("注册");
        ab1.setBounds(250, 20, 200, 40); // 窗口宽600时居中[6](@ref)
        add(ab1);

        // 用户名区域
        JLabel ab2 = new JLabel("用户名：");
        ab2.setBounds(50, 100, 60, 20); // 左对齐[8](@ref)
        add(ab2);

        JTextField txt = new JTextField();
        txt.setBounds(100, 100, 150, 20); // 标签右侧+10间距[6](@ref)
        add(txt);

        // 密码区域
        JLabel ab3 = new JLabel("密码：");
        ab3.setBounds(350, 100, 80, 20); // 垂直间隔50[8](@ref)
        add(ab3);

        JPasswordField txt2 = new JPasswordField();
        txt2.setBounds(400, 100, 150, 20);
        add(txt2);

        // 性别选择
        JLabel ab4 = new JLabel("性别：");
        ab4.setBounds(50, 180, 80, 20); // 垂直间隔50[8](@ref)
        add(ab4);
        JRadioButton sex1 = new JRadioButton("男");
        JRadioButton sex2 = new JRadioButton("女");
        JRadioButton sex3 = new JRadioButton("无");
        ButtonGroup sex = new ButtonGroup();
        sex.add(sex3);
        sex.add(sex2);
        sex.add(sex1);
        sex1.setBounds(100, 180, 50, 20);
        sex2.setBounds(150, 180, 50, 20);
        sex3.setBounds(200, 180, 50, 20);
        add(sex1);
        add(sex2);
        add(sex3);

        // 昵称
        JLabel ab5 = new JLabel("昵称：");
        ab5.setBounds(350, 180, 80, 20); // 垂直间隔50[8](@ref)
        add(ab5);
        JTextField txt3 = new JTextField();
        txt3.setBounds(400, 180, 150, 20); // 标签右侧+10间距[6](@ref)
        add(txt3);

        // 按钮区域（水平居中）
        JButton bu2 = new JButton("注册");
        bu2.setBounds(100, 250, 100, 35); // 间隔50[6](@ref)
        add(bu2);
        bu2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try (FileWriter wr = new FileWriter("./name.txt", true)) {
                    wr.write(txt3.getText() + ","); // 新的一行
                    wr.write(txt.getText() + ",");
                    wr.write(new String(txt2.getPassword()));
                    wr.write(",");

                    wr.close();

                    JOptionPane.showMessageDialog(null, "你好"+new String(txt3.getText())+"\n"+"注册成功，请返回登录");
                } catch (IOException e1) {
                    System.out.println("写入失败");
                }
            }
        });

        JButton bu3 = new JButton("返回登录");
        bu3.setBounds(400, 250, 100, 35);
        add(bu3);
        bu3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new denglu();
            }
        });

        setVisible(true);
    }
}