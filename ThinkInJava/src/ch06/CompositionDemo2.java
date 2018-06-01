package ch06;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by wsn on 2018/5/4.
 */
class Soap{
    private String s;

    Soap() {
        System.out.println("Soap()");
        s = new String("Constructed");
    }

    public String toString() {
        return s;
    }
}

public class CompositionDemo2 {
    private String
            s1 = new String("Happy"),
            s2 = "Happy",
            s3, s4;

    Soap castille;
    int i;
    float toy;

    CompositionDemo2() {
        System.out.println("Inside Bath()");
        s3 = new String("joy");
        i = 47;
        toy = 3.14f;
        castille = new Soap();
    }

    void print() {
        if (s4 == null) {
            s4 = new String("joy");
        }
        System.out.println("s1 = " + s1);
        System.out.println("s2 - " + s2);
        System.out.println("s3 = " + s3);
        System.out.println("s4 = " + s4);
        System.out.println("i = " + i);
        System.out.println("toy = " + toy);
        System.out.println("castille = " + castille);
    }

    public static void main(String[] args) {
        CompositionDemo2 b = new CompositionDemo2();
        b.print();
    }
}
