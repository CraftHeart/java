package ch07;

/**
 * Created by wsn on 2018/5/20.
 */
interface Instrument5 {
    int i = 5;  // 默认是static & final

    // 接口中的方法不能有实现，且默认是Public
    void play();
    String what();
    void adjust();
}

class Wind5 implements Instrument5 {
    public void play() {
        System.out.println("Wind5.play()");
    }
    public String what() { return "Wind5";}
    public void adjust() {}
}

class Woodwind5 extends Wind5 {
    public void play() {
        System.out.println("Woodwind5.play()");
    }

    public String what() {return "Woodwind5";}
}
public class InterfaceDemo {
}
