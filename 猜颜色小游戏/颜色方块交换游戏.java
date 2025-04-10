import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 颜色方块交换游戏主类，继承自 JFrame 用于创建窗口
public class 颜色方块交换游戏 extends JFrame {
    // 定义最大尝试次数为 10 次
    private static int 最大尝试次数 = 10;
    // 当前游戏关卡，初始为第 3 关
    private int 当前关卡 = 3;
    // 已使用的尝试次数，初始为 0
    private int 已尝试次数 = 0;
    // 目标颜色列表，存储每个关卡的目标颜色
    private List<Color> 目标颜色列表;
    // 颜色按钮列表，存储游戏中的颜色方块按钮
    private List<JButton> 颜色按钮列表;
    // 记录用户第一次选择的按钮索引，初始为 -1 表示未选择
    private int 首次选择索引 = -1;
    // 状态标签，用于显示当前关卡和剩余尝试次数
    private JLabel 状态标签;
    // 按钮面板，用于放置颜色方块按钮
    private JPanel 按钮面板;

    // 构造函数，初始化界面并开始新游戏
    public 颜色方块交换游戏() {
        初始化界面();
        开始新游戏();
    }

    // 初始化界面的方法
    private void 初始化界面() {
        // 设置窗口标题为“颜色方块交换游戏”
        setTitle("milkcandy");
        // 设置窗口大小为 600x400 像素
        setSize(600, 400);
        // 设置窗口关闭操作为退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 使用 GridBagLayout 布局管理器，以便更灵活地控制组件位置
        setLayout(new GridBagLayout());

        // 创建状态标签，显示当前关卡和剩余尝试次数
        状态标签 = new JLabel("第 1 关，剩余尝试次数: " + (最大尝试次数 - 已尝试次数));
        // 设置状态标签文本水平居中显示
        状态标签.setHorizontalAlignment(JLabel.CENTER);

        // 创建 GridBagConstraints 对象，用于设置组件的布局约束
        GridBagConstraints 布局约束 = new GridBagConstraints();
        // 设置组件在网格中的列索引为 0
        布局约束.gridx = 0;
        // 设置组件在网格中的行索引为 0
        布局约束.gridy = 0;
        // 设置组件在水平方向上填充可用空间
        布局约束.fill = GridBagConstraints.HORIZONTAL;
        // 设置组件的外部间距，上边距为 10 像素
        布局约束.insets = new Insets(10, 0, 0, 0);
        // 将状态标签添加到窗口中，并应用布局约束
        add(状态标签, 布局约束);

        // 创建按钮面板，使用 FlowLayout 布局管理器，按钮水平居中排列
        按钮面板 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // 重新创建 GridBagConstraints 对象，用于设置按钮面板的布局约束
        布局约束 = new GridBagConstraints();
        // 设置按钮面板在网格中的列索引为 0
        布局约束.gridx = 0;
        // 设置按钮面板在网格中的行索引为 1
        布局约束.gridy = 1;
        // 设置按钮面板在水平方向上的权重为 1，使其可以占用可用空间
        布局约束.weightx = 1.0;
        // 设置按钮面板在垂直方向上的权重为 1，使其可以占用可用空间
        布局约束.weighty = 1.0;
        // 设置按钮面板在网格中的对齐方式为居中
        布局约束.anchor = GridBagConstraints.CENTER;
        // 将按钮面板添加到窗口中，并应用布局约束
        add(按钮面板, 布局约束);

        // 将窗口居中显示在屏幕上
        setLocationRelativeTo(null);
    }

    // 开始新游戏的方法
    private void 开始新游戏() {
        // 如果当前关卡超过 10 关，显示通关提示并退出程序
        if (当前关卡 > 10) {
            JOptionPane.showMessageDialog(this, "真厉害呢，通关啦！");
            System.exit(0);
        }

        // 重置已尝试次数为 0
        已尝试次数 = 0;
        // 更新状态标签的文本，显示当前关卡和剩余尝试次数
        状态标签.setText("第 " + (当前关卡 - 2) + " 关，剩余尝试次数: " + (最大尝试次数 - 已尝试次数));

        // 移除按钮面板中的所有组件
        按钮面板.removeAll();

        // 初始化目标颜色列表
        目标颜色列表 = new ArrayList<>();
        // 初始化颜色按钮列表
        颜色按钮列表 = new ArrayList<>();

        // 为当前关卡生成目标颜色
        for (int i = 0; i < 当前关卡; i++) {
            目标颜色列表.add(生成随机颜色());
        }

        // 复制目标颜色列表，用于打乱顺序
        List<Color> 打乱顺序后的颜色列表 = new ArrayList<>(目标颜色列表);
        // 打乱颜色顺序
        Collections.shuffle(打乱顺序后的颜色列表);

        // 创建颜色方块按钮并添加到按钮面板和颜色按钮列表中
        for (int i = 0; i < 当前关卡; i++) {
            JButton 颜色按钮 = new JButton();
            // 设置按钮的背景颜色为打乱顺序后的颜色
            颜色按钮.setBackground(打乱顺序后的颜色列表.get(i));
            // 设置按钮的大小为 50x50 像素
            颜色按钮.setPreferredSize(new Dimension(50, 50));
            // 为按钮添加点击事件监听器
            颜色按钮.addActionListener(new 按钮点击监听器(i));
            // 将按钮添加到按钮面板中
            按钮面板.add(颜色按钮);
            // 将按钮添加到颜色按钮列表中
            颜色按钮列表.add(颜色按钮);
        }

        // 计算初始时正确位置的方块数量
        int 正确方块数量 = 获取正确方块数量();
        // 显示初始时正确位置的方块数量提示框
        JOptionPane.showMessageDialog(this, "初始时正确位置的方块数量: " + 正确方块数量);

        // 重新验证组件的布局
        revalidate();
        // 重绘组件
        repaint();
    }

    // 生成随机颜色的方法
    private Color 生成随机颜色() {
        // 生成 0 到 255 之间的随机 RGB 值
        return new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
    }

    // 获取当前正确位置的方块数量的方法
    private int 获取正确方块数量() {
        int 计数 = 0;
        // 遍历颜色按钮列表
        for (int i = 0; i < 当前关卡; i++) {
            // 如果按钮的背景颜色与目标颜色相同，则计数加 1
            if (颜色按钮列表.get(i).getBackground().equals(目标颜色列表.get(i))) {
                计数++;
            }
        }
        return 计数;
    }

    // 按钮点击事件监听器类
    private class 按钮点击监听器 implements ActionListener {
        // 按钮的索引
        private int 索引;

        // 构造函数，初始化按钮索引
        public 按钮点击监听器(int 索引) {
            this.索引 = 索引;
        }

        // 处理按钮点击事件的方法
        @Override
        public void actionPerformed(ActionEvent e) {
            // 如果首次选择索引为 -1，表示还未进行第一次选择
            if (首次选择索引 == -1) {
                // 记录第一次选择的按钮索引
                首次选择索引 = 索引;
            } else {
                // 已尝试次数加 1
                已尝试次数++;
                // 交换两个按钮的背景颜色
                Color 临时颜色 = 颜色按钮列表.get(首次选择索引).getBackground();
                颜色按钮列表.get(首次选择索引).setBackground(颜色按钮列表.get(索引).getBackground());
                颜色按钮列表.get(索引).setBackground(临时颜色);

                // 计算当前正确位置的方块数量
                int 正确方块数量 = 获取正确方块数量();
                // 显示当前正确位置的方块数量提示框
                JOptionPane.showMessageDialog(颜色方块交换游戏.this, "当前正确位置的方块数量: " + 正确方块数量);

                // 如果正确方块数量等于当前关卡的方块数量，说明通过本关
                if (正确方块数量 == 当前关卡) {
                    JOptionPane.showMessageDialog(颜色方块交换游戏.this, "恭喜你，好厉害哦");
                    // 关卡加 1
                    当前关卡++;
                    最大尝试次数++;
                    最大尝试次数++;
                    // 开始新的关卡
                    开始新游戏();
                }
                // 如果已尝试次数达到最大尝试次数，游戏结束
                else if (已尝试次数 >= 最大尝试次数) {
                    JOptionPane.showMessageDialog(颜色方块交换游戏.this, "尝试次数已用完，杂鱼~！");
                    try {
                        // 暂停 3 秒（3000 毫秒）
                        Thread.sleep(2000);
                    } catch (InterruptedException e1) {
                        // 处理中断异常（例如清理资源或退出）
                        Thread.currentThread().interrupt(); // 重新设置中断标志
                    }
                    System.exit(0);
                }
                // 否则，更新状态标签的文本，显示当前关卡和剩余尝试次数
                else {
                    状态标签.setText("第 " + (当前关卡 - 2) + " 关，剩余尝试次数: " + (最大尝试次数 - 已尝试次数));
                }

                // 重置首次选择索引为 -1
                首次选择索引 = -1;
            }
        }
    }

    // 主方法，程序入口
    public static void main(String[] args) {
        // 在事件调度线程中创建并显示窗口
        EventQueue.invokeLater(() -> {
            颜色方块交换游戏 游戏 = new 颜色方块交换游戏();
            游戏.setVisible(true);
        });
    }
}