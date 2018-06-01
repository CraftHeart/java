package ch05;

/**
 * Created by wsn on 2018/4/16.
 */
public class Pie {
    // 包内可见
    void f(){
        System.out.println("This is Pie friendly f()");
    }

    // 所有类都可见
    public void pub() {
        System.out.println("This is Pie public pub()");
    }


    // 包内可见
    protected void pro() {
        System.out.println("This is Pie protected pro()");
    }

    // 所有类都不可见
    private void pri() {
        System.out.println("This is Pie private pri()");
    }
}
