package ch07;

/**
 * Created by wsn on 2018/5/20.
 */

class Useful {
    public void f() {System.out.println("Useful f()");}
    public void g() {System.out.println("Useful g()");}
}

class MoreUseful extends Useful {
    public void f() {System.out.println("MoreUseful f()");}
    public void g() {System.out.println("MoreUseful g()");}

    public void u() {System.out.println("MoreUseful u()");}
}
public class RTTI
{
    public static void main(String[] args){
        Useful[] x = {new Useful(), new MoreUseful()};

        x[0].f();
        x[0].g();
        x[1].g();
        x[1].f();

//        !x[1].u();  // method not found in Useful
        ((MoreUseful)x[1]).u();   // 下溯造型
//        ((MoreUseful)x[0]).u();  // 运行时错误
    }
}
