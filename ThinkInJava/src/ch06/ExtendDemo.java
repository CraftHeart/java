package ch06;

/**
 * Created by wsn on 2018/5/19.
 */

class Cleaner {
    private String s = new String("Cleanser");
    public void append(String a) {
        s += a;
    }
    public void dilute(){
        append(" dilute()");
    }
    public void apply(){
        append(" apply()");
    }
    public void scrub() {
        append(" scrub()");
    }
    public void print(){
        System.out.println(s);
    }

    public static void main(String[] args){
        Cleaner x = new Cleaner();
        x.dilute();
        x.apply();
        x.scrub();
        x.print();
    }
}

class Game{
    Game(int i) {
        System.out.println("Game constructor");
    }
}

class BoardGame extends Game{
    BoardGame(int i){
        super(i);
        System.out.println("BoardGame constructor");
    }
}

class Chess extends BoardGame {
    Chess(int i){
        super(i);
        System.out.println("Chess constructor");
    }
}

public class ExtendDemo  extends Cleaner {
    public void scrub(){
        append(" ExtendDemo.scrub()");
        super.scrub();
    }

    public void foam(){
        append(" foam()");
    }

    public static void main(String[] args) {
        ExtendDemo e = new ExtendDemo();
        e.dilute();
        e.apply();
        e.scrub();
        e.foam();
        e.print();
        System.out.println("Testing base class: ");
        Cleaner.main(args);

        Chess chess = new Chess(1);
    }
}
