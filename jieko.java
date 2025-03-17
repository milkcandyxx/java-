package jieko;
import java.util.Scanner;//引用Scanner类用于输入
/*接口类似与抽象类，
但是一个类可以实现多个接口，
一个类只能继承一个抽象类
 */
/*##########################by milkcandy##########################*/
//单接口
interface shuzhi {//接口
    double s();//计算面积
    double l();//计算周长
}
class juxing1 implements shuzhi {//实现接口
    double x, y;
    public void juxing(int x, int y) {//初始化长和宽
        this.x = x;
        this.y = y;
    }
    @Override
    public double s() {//计算面积
        return x*y;
    }
    @Override
    public double l() {//计算周长
        return 2*x+2*y;
    }
}
//多接口
interface shuchu{
    default void shuchu1(double a){// 默认方法，提供一个默认的打印信息实现,可重写
        System.out.println("体积"+a+"\t默认方法");
    }
    static void shuchu2(double a){// 静态方法，用于创建一个通用的打印消息，可不创建对象引用
        System.out.println("周长"+a+"\t静态方法");
    }
}
class juxing2 implements shuzhi,shuchu {//实现多接口
    double x, y;
    public void juxing(int x, int y) {//初始化长和宽
        this.x = x;
        this.y = y;
    }
    @Override
    public double s() {//计算面积
        return x*y;
    }
    @Override
    public double l() {//计算周长
        return 2*x+2*y;
    }
}
public class jieko {
    public static void main(String[] args) {
        System.out.println("长方形面积周长计算机兼接口演示");
        Scanner sc = new Scanner(System.in);
        juxing1 j1 = new juxing1();
        juxing2 j2 = new juxing2();//创建对象
        System.out.print("输入长");
        int x = sc.nextInt();//输入长
        System.out.print("输入宽");
        int y = sc.nextInt();//输入宽
        System.out.print("输入序号\t1.单接口无输出\t2.多接口有输出");
        int n = sc.nextInt();//选择
        if(n==1){//进入单接口，无输出的，进行测试
            j1.juxing(x,y);//初始化
            System.out.println("体积"+j1.s());//类中无输出，所有这里自己写输出
            System.out.println("周长"+j1.l());
        }
        else if(n==2){
            j2.juxing(x,y);
            j2.shuchu1(j2.s());//类中有输出，
            shuchu.shuchu2(j2.l());//静态方法可以直接引用
        }
    }
}
