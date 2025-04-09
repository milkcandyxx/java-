package www;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class caidan extends moban {

    public caidan() {
        JLabel ab1=new JLabel("菜单栏");
        ab1.setBounds(280, 20, 200, 40); // 窗口宽600时居中[6](@ref)
        add(ab1);

        JButton bu1 = new JButton("写入");
        bu1.setBounds(100, 125, 150, 50); // 总宽300分三个按钮+间距[8](@ref)
        add(bu1);
        bu1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new xieru();
                dispose();

            }
        });

        JButton bu2 = new JButton("做题");
        bu2.setBounds(350, 125, 150, 50); // 总宽300分三个按钮+间距[8](@ref)
        add(bu2);
        bu2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new zuoti();
                dispose();

            }
        });

        JButton bu3 = new JButton("修改");
        bu3.setBounds(100, 250, 150, 50); // 总宽300分三个按钮+间距[8](@ref)
        add(bu3);
        bu3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new zhuce();
                dispose();
            }
        });

        JButton bu4 = new JButton("退出");
        bu4.setBounds(350, 250, 150, 50); // 总宽300分三个按钮+间距[8](@ref)
        add(bu4);
        bu4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);

    }
}
