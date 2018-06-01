package ch09;

import ch06.ExtendDemo;
import com.sun.deploy.security.MozillaMyKeyStore;

/**
 * Created by wsn on 2018/5/25.
 */
class MyException extends Exception {
    public MyException() {}
    public MyException(String msg) { super(msg);}
}

public class ExceptionDemo {
    public static void f() throws MyException {
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace();
        }

        try {
            g();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
