package www;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class zuoti extends moban implements ItemListener {
    int i=1;
    JTextArea txt;
    JTextArea txt1;
    JTextArea txt2;
    JTextArea txt3;
    JTextArea txt4;
    String timu = null;
    String axuan= null;
    String bxuan = null;
    String cxuan = null;
    String dxuan = null;
    String daan="A",daan1=null ;
    JRadioButton ab1,ab2,ab3,ab4;
    public zuoti() {
        txt = new JTextArea();
        txt.setEditable(false);
        txt.setBounds(50, 20, 500, 100);
        add(txt);

        txt1 = new JTextArea();
        txt1.setEditable(false);
        txt1.setBounds(150, 140, 350, 20);
        add(txt1);

        txt2 = new JTextArea();
        txt2.setEditable(false);
        txt2.setBounds(150, 180, 350, 20);
        add(txt2);

        txt3 = new JTextArea();
        txt3.setEditable(false);
        txt3.setBounds(150, 220, 350, 20);
        add(txt3);

        txt4 = new JTextArea();
        txt4.setEditable(false);
        txt4.setBounds(150, 260, 350, 20);
        add(txt4);


        ab1=new JRadioButton("A");
        ab2=new JRadioButton("B");
        ab3=new JRadioButton("C");
        ab4=new JRadioButton("D");
        ab1.addItemListener(this);
        ab2.addItemListener(this);
        ab3.addItemListener(this);
        ab4.addItemListener(this);
        ButtonGroup bg=new ButtonGroup();
        bg.add(ab1);
        bg.add(ab2);
        bg.add(ab3);
        bg.add(ab4);
        JPanel panel=new JPanel((new GridLayout(4, 1)));
        panel.add(ab1);
        panel.add(ab2);
        panel.add(ab3);
        panel.add(ab4);
        panel.setBounds(100, 130, 50, 160);
        add(panel);

        JButton bu = new JButton("提交");
        bu.setBounds(100, 300, 100, 35); // 总宽300分三个按钮+间距[8](@ref)
        add(bu);
        bu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(daan1.equals(daan)){
                    JOptionPane.showMessageDialog(null, "答对了，真厉害");
                }else{
                    JOptionPane.showMessageDialog(null, "答错了，啧啧啧");
                }

            }
        });


        try {
            // 使用 Files.lines() 方法获取文件的行流，并统计行数
            int hang = (int) Files.lines(Paths.get("./timu.txt")).count();
            i=hang;
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader re = new BufferedReader(new FileReader("./timu.txt"))) {
            String line=null;
            for (int j=i; j>0;j--){
                line = re.readLine();

            }
            String[] name = line.split(",");
            timu = name[0];
            axuan = name[1];
            bxuan = name[2];
            cxuan = name[3];
            dxuan = name[4];
            daan1 = name[5];
            txt.setText(timu);
            txt1.setText(axuan);
            txt2.setText(bxuan);
            txt3.setText(cxuan);
            txt4.setText(dxuan);

        } catch (ArrayIndexOutOfBoundsException | IOException a) {
            System.out.println("读取失败");
        }





        JButton bu1 = new JButton("返回");
        bu1.setBounds(400, 300, 100, 35); // 总宽300分三个按钮+间距[8](@ref)
        add(bu1);
        bu1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new caidan();

                dispose();
            }
        });

        JButton bu2 = new JButton("下一题");
        bu2.setBounds(250, 300, 100, 35); // 总宽300分三个按钮+间距[8](@ref)
        add(bu2);
        bu2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                i--;
               xiayi();
            }
        });


        setVisible(true);
    }

    public void xiayi() {
        try (BufferedReader re = new BufferedReader(new FileReader("./timu.txt"))) {
            String line=null;
            if(i<=0){
                JOptionPane.showMessageDialog(null, "没有下一题了哦");
                return;
            }
            for (int j=i; j>0;j--){
                line = re.readLine();

            }
            String[] name = line.split(",");
            timu = name[0];
            axuan = name[1];
            bxuan = name[2];
            cxuan = name[3];
            dxuan = name[4];
            daan1 = name[5];
            txt.setText(timu);
            txt1.setText(axuan);
            txt2.setText(bxuan);
            txt3.setText(cxuan);
            txt4.setText(dxuan);

        } catch (ArrayIndexOutOfBoundsException | IOException a) {
            System.out.println("读取失败");
        }
        }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==ab1){
            daan="A";
        }
        if (e.getSource()==ab2){
            daan="B";
        }
        if (e.getSource()==ab3){
            daan="C";
        }
        if (e.getSource()==ab4){
            daan="D";
        }
    }
}