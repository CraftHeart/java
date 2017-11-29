package ch05;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class ClassDemo {
    public static class BaseClass{
        public int a = 10;
        public int b;
        public String name;

        public BaseClass(int b, String name) {
            System.out.println("调用父类的构造器");
            this.b = b;
            this.name = name;
        }
    }
    public static class SubClass extends BaseClass{
        public int a = 8;
        public double x;
        public String color;

        public SubClass(double x, String color, int a, String name) {
            // 通过super来调用父类的构造器，super调用父类构造器时，必须在子类构造器执行体的第一行
            super(a, name);
            System.out.println("调用子类的构造器");
            this.x = x;
            this.color = color;
        }

        public  void getOwner() {
            System.out.println(this.a);
        }

        public  void getBase() {
            System.out.println(super.a);
        }
    }

    // 自动装箱和自动拆箱
    public static void autoBoxingUnboxing() {
        // 直接把一个基本类型变量赋给Integer对象
        Integer integer = 5;  // 自动装箱
        // 直接把一个boolean类型变量赋给一个Object类型的变量
        Object object = true;  // 自动装箱
        // 直接把一个Integer对象赋给Int 类型
        int a = integer;  // 自动拆箱
        if (object instanceof Boolean) {
            // 先把object强制转换为Boolean类型，再赋给boolean变量
            boolean b = (Boolean)object;
            System.out.println(b);
        }
    }

    // 利用包装类实现基本类型变量和字符串之间的转换。
    /*
    * 字符串类型的值转换为基本类型的值：
    * - 利用包装类提供的parseXxx(String s)静态方法(除了Character之外的包装类都提供了该方法)
    * - 利用包装类提供的Xxx(String s)构造器*/
    public static void primitive2String() {
        String intStr = "123";
        // 把一个特定字符串转换为Int变量
        int it1 = Integer.parseInt(intStr);
        int it2 = new Integer(intStr);
        System.out.println(it1 + " " + it2);
        String floatStr = "1.23";
        // 把特定的字符串转换为float变量
        float ft1 = Float.parseFloat(floatStr);
        float ft2 = new Float(floatStr);
        System.out.println(ft1 + " " + ft2);

        // 把一个float变量转换成为String变量
        String ftStr = String.valueOf(1.234f);
        System.out.println(ftStr);
        // 把一个double变量转换为String变量
        String dbStr = String.valueOf(2.23);
        System.out.println(dbStr);
        // 把一个boolean变量转换为String变量
        String boolStr = String.valueOf(true);
        System.out.println(boolStr.toUpperCase());

        // 将基本类型转换为字符串的更简单方法
        String intStr1 = 12 + "";
        String boolStr2 = true + "";
        System.out.println(intStr1 + " " + boolStr2);

        /*
        * 虽然包装类型的变量是引用数据类型，但包装类的实例可以与数值类型的值进行比较，这种比较是直接去除包装类实例所包装的数值
        * 来进行比较的。
        * 两个包装类的实例进行比较的情况下，只有两个包装类引用指向同一个对象时才会返回true。*/
        System.out.println(new Integer(5) > 4);   // true
        System.out.println(new Integer(5) == 5);  // true
        System.out.println(new Integer(5) == new Integer(5));  // false
        int a = 127;
        Integer integer1 = a;
        Integer integer2 = a;
        // 由于Integer的设计原因，只有当a在[-128, 127]之间时，下面的输出为true，否则输出false，因为不在这个区间的时候
        // 会自动创建新对象
        System.out.println(integer1 == integer2); // true
    }

    public static class ToStringDemo{
        public String toString() {
            return "This is ToStringDemo test";
        }
    }
    public static void toStringTest() {
        ToStringDemo toStringDemo = new ToStringDemo();
        System.out.println(toStringDemo);
    }

    /*
    * == 与 equals方法：
    * 当使用==来判断两个变量是否相等的时候，如果两个变量是基本类型变量，且都是数值类型，则只要两个变量的值相等，就返回true,
    * 但对于两个引用类型变量，只有它们指向同一个对象时，==判断才会返回true。==不可以用来比较类型上没有父子关系的对象。*/
    public static void equalTest() {
        int it = 6;
        float ft = 6.0f;
        System.out.println(it == ft);  // true
        String string1 = new String("hello");  // 会产生两个字符串对象，一个在常量池中，一个在后面new的内存块中
        String string2 = new String("hello");
        System.out.println(string1 == string2);  // false
        System.out.println(string1.equals(string2));  // true
        String string3 = "hello";  // 只有一个字符串对象，在常量池中
        String string4 = "hello";
        System.out.println(string3 == string4);  // true
        System.out.println(string3.equals(string4));  // true
        String s5 = "hel";
        String s6 = "lo";
        String s7 = "hel" + "lo";
        String s8 = s5 + s6;  // 会构建新对象
        System.out.println(s7 == string3);  // true
        System.out.println(s8 == string3);  // false
    }

    /*
    * 接口*/
    interface InterfaceA{
        int X = 10;   // 成员变量默认使用public static final 修饰， 因此这里X是一个常量

        void get();  // 成员普通方法默认使用public abstract修饰。

        default void print() {  // 默认方法必须使用default修饰
            System.out.println("InterfaceA print");
        }
    }
    interface InterfaceB extends InterfaceA{

    }

    public static void interfaceDemo() {
        System.out.println(InterfaceA.X);
        System.out.println(InterfaceB.X);
    }

    public static void main(String[] args) {
//        SubClass subClass = new SubClass(1.0, "color", 1, "name");
//        subClass.getBase();
//        subClass.getOwner();

        // instanceof 前面操作数为变量，后面的操作数为类，用来判断前面的对象是否是后面得类，或其子类、实现类的实例
//        System.out.println(subClass instanceof BaseClass);  // true

//        primitive2String();

//        toStringTest();
        equalTest();
    }
}
