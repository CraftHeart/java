package ch07;

import sun.security.krb5.internal.crypto.Des;

/**
 * Created by wsn on 2018/5/20.
 * 内部类
 */
public class InnerClassDemo1 {
    class Contents {
        private int i = 11;
        public int value() { return i;}
    }

    class Destination {
        private String labbel;
        Destination(String whereTo){
            labbel = whereTo;
        }
        String readLabel() { return labbel; }
    }

    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = new Destination(dest);
    }

    public static void main(String[] args) {
        InnerClassDemo1 innerClassDemo1 = new InnerClassDemo1();
        innerClassDemo1.ship("China");
    }
}
