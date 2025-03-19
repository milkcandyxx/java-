package jieko; // 定义包名为 jieko

import java.util.Scanner; // 导入 Scanner 类，用于从控制台获取用户输入

/* 接口类似于抽象类，
   但是一个类可以实现多个接口，
   一个类只能继承一个抽象类
 */
/*##########################by milkcandy##########################*/

// 单接口
interface shuzhi { // 定义一个接口 shuzhi
    double s(); // 抽象方法，用于计算面积
    double l(); // 抽象方法，用于计算周长
}

// 实现 shuzhi 接口的类
class juxing1 implements shuzhi {
    double x, y; // 定义两个成员变量，分别表示矩形的长和宽

    // 初始化长和宽的方法
    public void juxing(int x, int y) {
        this.x = x; // 将传入的参数 x 赋值给成员变量 x
        this.y = y; // 将传入的参数 y 赋值给成员变量 y
    }

    @Override
    public double s() { // 实现接口中的 s() 方法，计算矩形的面积
        return x * y; // 面积公式：长 × 宽
    }

    @Override
    public double l() { // 实现接口中的 l() 方法，计算矩形的周长
        return 2 * x + 2 * y; // 周长公式：2 × 长 + 2 × 宽
    }
}

// 接口的继承
interface shuchu { // 定义一个接口 shuchu，用于输出计算结果
    // 默认方法，提供一个默认的打印信息实现，子类可以重写
    default void shuchu1(double a) {
        System.out.println("体积" + a + "\t默认方法"); // 打印体积信息
    }

    // 静态方法，用于创建一个通用的打印消息，可以直接通过接口名调用
    static void shuchu2(double a) {
        System.out.println("周长" + a + "\t静态方法"); // 打印周长信息
    }
}

// 继承 shuchu 接口的子接口
interface shuchu2 extends shuchu {
    // 默认方法，输出接口继承的信息
    default void shuchu2() {
        System.out.println("这里是接口的继承"); // 打印接口继承的信息
    }
}

// 多接口实现类
class juxing2 implements shuzhi, shuchu2 { // 实现 shuzhi 和 shuchu2 接口
    double x, y; // 定义两个成员变量，分别表示矩形的长和宽

    // 初始化长和宽的方法
    public void juxing(int x, int y) {
        this.x = x; // 将传入的参数 x 赋值给成员变量 x
        this.y = y; // 将传入的参数 y 赋值给成员变量 y
    }

    @Override
    public double s() { // 实现接口中的 s() 方法，计算矩形的面积
        return x * y; // 面积公式：长 × 宽
    }

    @Override
    public double l() { // 实现接口中的 l() 方法，计算矩形的周长
        return 2 * x + 2 * y; // 周长公式：2 × 长 + 2 × 宽
    }
}

// 主类
public class jieko {
    public static void main(String[] args) {
        System.out.println("长方形面积周长计算机兼接口演示"); // 打印程序标题

        Scanner sc = new Scanner(System.in); // 创建 Scanner 对象，用于接收用户输入
        juxing1 j1 = new juxing1(); // 创建 juxing1 类的对象，用于单接口测试
        juxing2 j2 = new juxing2(); // 创建 juxing2 类的对象，用于多接口测试

        // 用户输入长和宽
        System.out.print("输入长");
        int x = sc.nextInt(); // 从控制台读取用户输入的长，并赋值给变量 x
        System.out.print("输入宽");
        int y = sc.nextInt(); // 从控制台读取用户输入的宽，并赋值给变量 y

        // 用户选择功能
        System.out.print("输入序号\t1.单接口无输出\t2.多接口有输出");
        int n = sc.nextInt(); // 从控制台读取用户的选择，并赋值给变量 n

        if (n == 1) { // 如果用户选择 1，进入单接口测试
            j1.juxing(x, y); // 调用 juxing1 类的 juxing 方法，初始化长和宽
            System.out.println("体积" + j1.s()); // 调用 juxing1 类的 s() 方法计算面积，并打印结果
            System.out.println("周长" + j1.l()); // 调用 juxing1 类的 l() 方法计算周长，并打印结果
        } else if (n == 2) { // 如果用户选择 2，进入多接口测试
            j2.juxing(x, y); // 调用 juxing2 类的 juxing 方法，初始化长和宽
            j2.shuchu1(j2.s()); // 调用 juxing2 类的 shuchu1 方法，输出面积
            shuchu.shuchu2(j2.l()); // 调用 shuchu 接口的静态方法 shuchu2，输出周长
            j2.shuchu2(); // 调用 juxing2 类的 shuchu2 方法，输出接口继承的信息
        }
    }
}