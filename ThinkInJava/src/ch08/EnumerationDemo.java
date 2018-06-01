package ch08;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by wsn on 2018/5/23.
 */
class Cat2 {
    private int catNumber;

    Cat2(int i) {
        catNumber = i;
    }

    void print() {
        System.out.println("Cat number " + catNumber);
    }
}

class Dog2 {
    private int dogNumber;

    Dog2(int i) {
        dogNumber = i;
    }

    void print() {
        System.out.println("Dog number " + dogNumber);
    }
}

class Hamster {
    private int hamsterNumber;

    Hamster(int i) {
        hamsterNumber = i;
    }

    public String toString() {
        return "This is Hamster #" + hamsterNumber;
    }
}

class Printer {
    static void printAll(Enumeration e) {
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
    }
}

public class EnumerationDemo {

    public static void catAndDog() {
        Vector cats = new Vector();
        for(int i=0; i < 7; i++) {
            cats.addElement(new Cat2(i));
        }
        cats.addElement(new Dog2(7));

        Enumeration e = cats.elements();

        while (e.hasMoreElements()) {
            ((Cat2)e.nextElement()).print();
        }
    }

    public static void hamsterMaze() {
        Vector v = new Vector();
        for(int i=0; i < 3; i++) {
            v.addElement(new Hamster(i));
        }
        Printer.printAll(v.elements());
    }

    public static void main(String[] args) {
        hamsterMaze();
    }
}
