package ch07;

import sun.security.krb5.internal.crypto.Des;

/**
 * Created by wsn on 2018/5/20.
 */
public class InnerClassDemo2 {
    class Contents {
        private int i = 11;
        public int value() { return i;}
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() { return label; }
    }

    public Contents cont() {
        return new Contents();
    }

    public Destination to(String s) {
        return new Destination(s);
    }

    public void ship(String dest) {
        Contents c = cont();
        Destination d = to(dest);
    }

    public static void main(String[] args) {
        InnerClassDemo2 p = new InnerClassDemo2();
        p.ship("China");
        InnerClassDemo2 q = new InnerClassDemo2();

        // 使用内部类
        InnerClassDemo2.Contents c = q.cont();
        InnerClassDemo2.Destination d = q.to("China");
    }
}
