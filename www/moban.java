package www;

import javax.swing.*;
public class moban extends JFrame {
    public moban() {
        super("milkcandy");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(null); // 绝对布局[8](@ref)
        setLocationRelativeTo(null);
    }
    public void set(String a){
        super.setTitle(a);
    }
}
