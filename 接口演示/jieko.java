package jieko.接口演示;
// 导入Scanner类，用于从控制台读取用户输入
import java.util.Scanner;

/*
接口类似与抽象类，
但是一个类可以实现多个接口，
一个类只能继承一个抽象类
 */
/*##########################by milkcandy##########################*/

// 单接口定义
// 定义一个名为shuzhi的接口，接口中定义了两个抽象方法，用于计算面积和周长
interface shuzhi {
    // 抽象方法，用于计算面积，具体实现由实现该接口的类完成
    double s();
    // 抽象方法，用于计算周长，具体实现由实现该接口的类完成
    double l();
}

// 实现shuzhi接口的类
class juxing1 implements shuzhi {
    // 定义两个成员变量，用于存储长方形的长和宽
    double x, y;

    // 自定义方法，用于初始化长方形的长和宽
    public void juxing(int x, int y) {
        // 使用this关键字区分成员变量和方法参数
        this.x = x;
        this.y = y;
    }

    // 重写接口中的s方法，实现计算长方形面积的逻辑
    @Override
    public double s() {
        // 长方形面积计算公式：长 * 宽
        return x * y;
    }

    // 重写接口中的l方法，实现计算长方形周长的逻辑
    @Override
    public double l() {
        // 长方形周长计算公式：2 * 长 + 2 * 宽
        return 2 * x + 2 * y;
    }
}

// 定义一个用于输出信息的接口
interface shuchu {
    // 默认方法，提供一个默认的打印信息实现，实现该接口的类可以重写此方法
    default void shuchu1(double a) {
        // 打印体积信息，并提示这是默认方法
        System.out.println("体积" + a + "\t默认方法");
    }

    // 静态方法，用于创建一个通用的打印消息，不需要创建对象即可调用
    static void shuchu2(double a) {
        // 打印周长信息，并提示这是静态方法
        System.out.println("周长" + a + "\t静态方法");
    }
}

// 接口的继承，shuchu2接口继承自shuchu接口
interface shuchu2 extends shuchu {
    // 定义一个默认方法，用于输出接口继承的提示信息
    default void shuchu2() {
        System.out.println("这里是接口的继承");
    }
}

// 实现多个接口的类
class juxing2 implements shuzhi, shuchu2 {
    // 定义两个成员变量，用于存储长方形的长和宽
    double x, y;

    // 自定义方法，用于初始化长方形的长和宽
    public void juxing(int x, int y) {
        // 使用this关键字区分成员变量和方法参数
        this.x = x;
        this.y = y;
    }

    // 重写接口shuzhi中的s方法，实现计算长方形面积的逻辑
    @Override
    public double s() {
        // 长方形面积计算公式：长 * 宽
        return x * y;
    }

    // 重写接口shuzhi中的l方法，实现计算长方形周长的逻辑
    @Override
    public double l() {
        // 长方形周长计算公式：2 * 长 + 2 * 宽
        return 2 * x + 2 * y;
    }
}

// 主类，包含程序的入口点main方法
public class jieko {
    public static void main(String[] args) {
        // 输出程序的功能提示信息
        System.out.println("长方形面积周长计算机兼接口演示");
        // 创建Scanner对象，用于从控制台读取用户输入
        Scanner sc = new Scanner(System.in);
        // 创建juxing1类的对象，用于测试单接口功能
        juxing1 j1 = new juxing1();
        // 创建juxing2类的对象，用于测试多接口功能
        juxing2 j2 = new juxing2();
        // 提示用户输入长方形的长
        System.out.print("输入长");
        // 从控制台读取用户输入的长，并存储在变量x中
        int x = sc.nextInt();
        // 提示用户输入长方形的宽
        System.out.print("输入宽");
        // 从控制台读取用户输入的宽，并存储在变量y中
        int y = sc.nextInt();
        // 提示用户选择测试模式
        System.out.print("输入序号\t1.单接口无输出\t2.多接口有输出");
        // 从控制台读取用户输入的选择序号，并存储在变量n中
        int n = sc.nextInt();
        // 根据用户的选择执行不同的逻辑
        if (n == 1) {
            // 进入单接口测试模式，无输出的情况
            // 调用juxing1对象的juxing方法，初始化长和宽
            j1.juxing(x, y);
            // 手动输出长方形的面积信息
            System.out.println("体积" + j1.s());
            // 手动输出长方形的周长信息
            System.out.println("周长" + j1.l());
        } else if (n == 2) {
            // 进入多接口测试模式，有输出的情况
            // 调用juxing2对象的juxing方法，初始化长和宽
            j2.juxing(x, y);
            // 调用juxing2对象的shuchu1方法，输出长方形的面积信息
            j2.shuchu1(j2.s());
            // 直接调用shuchu接口的静态方法shuchu2，输出长方形的周长信息
            shuchu.shuchu2(j2.l());
            // 调用juxing2对象的shuchu2方法，输出接口继承的提示信息
            j2.shuchu2();
        }
    }
}