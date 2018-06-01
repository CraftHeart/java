package ch06;

import ch05.Pie;

/**
 * Created by wsn on 2018/4/16.
 */

class SubPie extends Pie {
    public void func() {
        Pie pie = new Pie();
        pie.pub();

        // 继承自另一个包内的类，可以访问其public 和 protected成员
        SubPie subPie = new SubPie();
        subPie.pub();
        subPie.pro();
    }
}
public class TestCh05 {
    public static void main(String[] args) {
        Pie pie = new Pie();
        pie.pub();
    }
}
