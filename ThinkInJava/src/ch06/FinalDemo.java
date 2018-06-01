package ch06;

/**
 * Created by wsn on 2018/5/20.
 */

class Value {
    int i = 1;
}
public class FinalDemo {
    // 编译时就是常数
    final int i1 = 9;
    static final int i2 = 99;

    //
    public static final int i3 = 39;

    final int i4 = (int) (Math.random() * 20);
    static final int i5 = (int) (Math.random() * 20);

    Value v1 = new Value();
    final Value v2 = new Value();
    static final Value v3 = new Value();

    final int[] a = {1, 2, 3, 4, 5, 6};

    public void print(String id) {
        System.out.println(id + ": " + "i4= " + i4 + ", i5= " + i5);
    }

    public static void main(String[] args) {
        FinalDemo fd1 = new FinalDemo();

        //! fd1.i1++;  // Error: 不能改变
        fd1.v2.i++; // 句柄是常量，对象不是常量
        fd1.v1 = new Value(); // 可以

        for(int i=0; i<fd1.a.length; i++) {
            fd1.a[i]++; //可以，数组对象不是常量
        }

        // 以下注释部分均不可以
//        fd1.v2 = new Value();
//        fd1.v3 = new Value();
//        fd1.a = new int[3];

        fd1.print("fd1");

        System.out.println("Creating new FinalDemo");
        FinalDemo fd2 = new FinalDemo();
        fd1.print("fd1");
        fd2.print("fd2");
    }
}
