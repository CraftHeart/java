package ch07;

import static java.lang.Math.PI;

public class MathDemo {
    public static void main(String[] args) {
        /*-------三角运算---------*/
        // 将弧度转换为角度
        System.out.println("Math.toDegrees(pi/3):"+Math.toDegrees(PI/3));
        // 将角度转换为弧度
        System.out.println("Math.toRadians(90):"+Math.toRadians(180));
        /*-------取整运算---------*/
        // 取整，返回小于目标数的最大整数
        System.out.println("Math.floor(-1.2):" + Math.floor(-1.2));  // -2.0
        // 取整，返回大于目标数的最小整数
        System.out.println("Math.ceil(1.2):" + Math.ceil(1.2));  // 2.0
        // 四舍五入
        System.out.println("Math.round(2.3):" + Math.round(2.3));  // 2
        System.out.println("Math.round(2.6):" + Math.round(2.6));  // 3

    }
}
