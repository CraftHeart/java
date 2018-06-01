package ch08;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Stack;

/**
 * Created by wsn on 2018/5/23.
 */
public class StackDemo {
    static String[] months = {"January", "February", "March", "April",
            "May", "June", "July", "August", "September",
            "October", "November", "December"};

    public static void main(String[] args) {
        Stack stk = new Stack();

        for(int i=0; i<months.length; i++) {
            stk.push(months[i] + " ");
        }

        System.out.println("skt = " + stk);

        stk.addElement("The last line");
        System.out.println("element 5 = " + stk.elementAt(5));

        while (!stk.empty()) {
            System.out.print(stk.pop() + ", ");
        }
    }
}
