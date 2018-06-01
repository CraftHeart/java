package ch08;

import java.util.Vector;

/**
 * Created by wsn on 2018/5/22.
 */

class Cat {
    private int catNumber;
    Cat(int i) {
        catNumber = i;
    }

    void print() {
        System.out.println("Cat #" + catNumber);
    }
}

class Dog {
    private int dogNumber;

    Dog(int i) {
        dogNumber = i;
    }

    void print() {
        System.out.println("Dog #" + dogNumber);
    }
}

class Mouse {
    private int mouseNumber;

    Mouse(int i) {
        mouseNumber = i;
    }

    public String toString() {
        return "This is Mouse #" + mouseNumber;
    }

    void print(String msg) {
        if (msg != null) {
            System.out.println(msg);
        }
        System.out.println("Mouse number " + mouseNumber);
    }
}

class MouseTrap {
    static void caughtYa(Object m) {
        Mouse mouse = (Mouse)m;
        mouse.print("Caught one!");
    }
}

class Gopher {
    private int gopherNumber;

    Gopher(int i) {
        gopherNumber = i;
    }

    void print(String msg) {
        if(msg != null)
            System.out.println("Gopher number " + gopherNumber);
    }
}

class GopherTrap {
    static void caughtYa(Gopher gopher) {
        gopher.print("Caught one!");
    }
}

class GopherVector {
    private Vector v = new Vector();

    public void addElement(Gopher m) {
        v.addElement(m);
    }

    public Gopher elementAt(int index) {
        return (Gopher) v.elementAt(index);
    }

    public int size() {
        return v.size();
    }
}

public class CollectionDemo {

     static void catsAndDogs() {
        Vector cats = new Vector();
        for (int i=0; i<7; i++) {
            cats.addElement(new Cat(i));
        }

        cats.addElement(new Dog(7));

        // 当打印第七个元素时，会抛出异常
        for(int i=0; i<cats.size(); i++) {
            ((Cat)cats.elementAt(i)).print();

            // Exception in thread "main" java.lang.ClassCastException: ch08.Dog cannot be cast to ch08.Cat
        }

//        for(int i=0; i<cats.size(); i++) {
//            cats.elementAt(i).print();
//        }
    }

    static void worksAnyway() {
        Vector mice = new Vector();

        for(int i=0; i<3; i++) {
            mice.addElement(new Mouse(i));
        }

        for(int i=0; i<mice.size(); i++) {
            System.out.println("Free mouse: " + mice.elementAt(i));
            MouseTrap.caughtYa(mice.elementAt(i));
        }
    }

    public static void gopherVector() {
        GopherVector gophers = new GopherVector();
        for (int i=0; i < 3; i++) {
            gophers.addElement(new Gopher(i));
        }
        for(int i=0; i < gophers.size(); i++) {
            GopherTrap.caughtYa(gophers.elementAt(i));
        }
    }

    public static void main(String[] args) {
//        catsAndDogs();
//        worksAnyway();
        gopherVector();
    }
}
