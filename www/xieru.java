package www;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class xieru extends moban{
    public xieru(){
        JLabel ab1=new JLabel("写入题目");
        ab1.setBounds(260, 0, 200, 40); // 窗口宽600时居中[6](@ref)
        add(ab1);

        JLabel ab2=new JLabel("题目");
        ab2.setBounds(60, 50, 80, 20); // 左对齐[8](@ref)
        add(ab2);

        JLabel ab6 =new JLabel("A");
        ab6.setBounds(80, 130, 80, 20); // 左对齐[8](@ref)
        add(ab6);
        JTextArea txt2 =new JTextArea();
        txt2.setLineWrap(true);
        txt2.setWrapStyleWord(true);
        txt2.setBounds(100, 125, 420, 30); // 标签右侧+10间距[6](@ref)
        add(txt2);

        JLabel ab3=new JLabel("B");
        ab3.setBounds(80, 170, 80, 20); // 左对齐[8](@ref)
        add(ab3);
        JTextArea txt3 =new JTextArea();
        txt3.setLineWrap(true);
        txt3.setWrapStyleWord(true);
        txt3.setBounds(100, 165, 420, 30); // 标签右侧+10间距[6](@ref)
        add(txt3);

        JLabel ab4 =new JLabel("C");
        ab4.setBounds(80, 210, 80, 20); // 左对齐[8](@ref)
        add(ab4);
        JTextArea txt4 =new JTextArea();
        txt4.setLineWrap(true);
        txt4.setWrapStyleWord(true);
        txt4.setBounds(100, 205, 420, 30); // 标签右侧+10间距[6](@ref)
        add(txt4);

        JLabel ab5 =new JLabel("D");
        ab5.setBounds(80, 250, 80, 20); // 左对齐[8](@ref)
        add(ab5);
        JTextArea txt5 =new JTextArea();
        txt5.setLineWrap(true);
        txt5.setWrapStyleWord(true);
        txt5.setBounds(100, 245, 420, 30); // 标签右侧+10间距[6](@ref)
        add(txt5);
       
        JTextArea txt=new JTextArea();
        txt.setLineWrap(true);
        txt.setWrapStyleWord(true);
        txt.setBounds(100, 50, 420, 50); // 标签右侧+10间距[6](@ref)
        add(txt);

        JLabel ab7 =new JLabel("答案");
        ab7.setBounds(230, 290, 80, 20); // 左对齐[8](@ref)
        add(ab7);
        String[] aaap ={"A","B","C","D"};
        JComboBox combo=new JComboBox(aaap);
        combo.setBounds(260, 292, 80, 20);
        add(combo);

        JButton bu1 = new JButton("写入");
        bu1.setBounds(100, 320, 100, 30); // 总宽300分三个按钮+间距[8](@ref)
        add(bu1);
        bu1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try (FileWriter wr = new FileWriter("./timu.txt",true)) {
                    wr.write(txt.getText() + ",");
                    wr.write(txt2.getText() + ",");
                    wr.write(txt3.getText() + ",");
                    wr.write(txt4.getText() + ",");
                    wr.write(txt5.getText() + ",");
                    wr.write(combo.getSelectedItem() + ","+"\n");

                    wr.close();

                    JOptionPane.showMessageDialog(null, "写入成功");
                    new caidan();
                    dispose();
                } catch (IOException e1) {
                    System.out.println("写入失败");
                }
            }
        });

        JButton bu2 = new JButton("批量导入");
        bu2.setBounds(400, 320, 100, 30); // 总宽300分三个按钮+间距[8](@ref)
        add(bu2);

        JButton bu3 = new JButton("返回");
        bu3.setBounds(250, 320, 100, 30); // 总宽300分三个按钮+间距[8](@ref)
        add(bu3);
        bu3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new caidan();

                dispose();
            }
        });








        setVisible(true);
    }
    }
