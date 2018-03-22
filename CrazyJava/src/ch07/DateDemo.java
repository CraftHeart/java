package ch07;

import java.util.Calendar;
import java.util.Date;

public class DateDemo {
    // Date是一个设计相当糟糕的类，因此Java官方推荐尽量少用Date的构造器和方法。
    public static void dateTest() {
        Date d1 = new Date();
        Date d2 = new Date(System.currentTimeMillis() + 100);
        System.out.println("d1:"+d1);
        System.out.println("d2:"+d2);
        System.out.println(d1.compareTo(d2));
        System.out.println(d1.before(d2));
    }

    // Calendar类可以更好的处理日期和时间
    public static void CalendarTest() {
        // Calendar是一个抽象类，只能通过静态方法getInstance()方法来获取Calendar对象
        Calendar calendar = Calendar.getInstance();
        // 从Calendar对象中抽取Date对象
        Date date = calendar.getTime();
        // 通过Date对象获得对应的Calendar对象
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date);

        // 取出年、月、日
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DATE));

        // 设置年月日时分秒
        calendar1.set(1994, 01, 8, 19, 0, 0);
        System.out.println(calendar1.getTime());
        calendar1.add(Calendar.YEAR, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.HOUR, 1);
        System.out.println(calendar1.getTime());

    }

    public static void main(String[] args) {
//        dateTest();
        CalendarTest();
    }
}
