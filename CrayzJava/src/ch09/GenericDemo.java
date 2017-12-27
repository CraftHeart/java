package ch09;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo {

    public static void GenericList() {
        // 创建一个只保存String类型的List
        List<String> list = new ArrayList<>();

        list.add("abc");
        list.add("def");
        // 如果add(5)就会报错
//        list.add(5);
        list.forEach(ele -> System.out.println(ele));
    }

    /*
    * 所谓泛型，就是允许定义在类、接口、方法时使用类型参数，这个类型参数将在声明变量、创建对象、调用方法时动态指定*/


    public static void main(String[] args)
    {
        GenericList();
    }
}
