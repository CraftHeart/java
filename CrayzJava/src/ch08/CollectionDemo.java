package ch08;

import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.stream.IntStream;

public class CollectionDemo {

    public static void collectionTest() {
        Collection collection = new ArrayList();

        collection.add("cuber");
        collection.add(6);

        System.out.println("collection 元素个数：" + collection.size());

        // 删除指定元素
        collection.remove(6);

        System.out.println("collection是否包含cuber: " + collection.contains("cuber"));
        collection.add(7);

        System.out.println("collection的元素："+collection);

        Collection collection1 = new HashSet();
        collection1.add(7);
        collection1.add("cuber");
        collection1.add(true);

        System.out.println("collection是否包含collection1所有元素：" + collection.containsAll(collection1));
        System.out.println("collection1是否包含collection所有元素： " + collection1.containsAll(collection));

        collection1.clear();
        System.out.println("collection是否包含collection1所有元素：" + collection.containsAll(collection1));

        // 使用lambda表达式遍历集合
        collection.forEach(obj -> System.out.println(obj));

        // 使用foreach遍历集合
        for (Object obj : collection) {
            System.out.print(obj+" ");
            if (obj.equals("cuber")) {
//                collection.remove(obj);  //会抛出异常
            }
        }
    }

    public static void retriveCollection() {
        Collection collection = new ArrayList();
        for(int i=0; i<10;i++) {
            collection.add(i);
        }

        // 使用Iterator遍历集合元素
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            // iterator返回类型是Object，所以需要进行强制类型转换
            int x = (int) iterator.next();

            if (x == 5) {
                iterator.remove();
                // 在迭代的过程中不允许对集合进行修改
//                collection.remove(x);   //会抛出异常
            }

            System.out.print(x+" ");
        }
        System.out.println("\n"+collection);

        iterator = collection.iterator();

        // 使用lambda表达式遍历Iterator
        iterator.forEachRemaining(obj->System.out.print(obj+ " "));
    }

    public static void collectionOperate() {
        Collection collection = new ArrayList();
        for(int i=0; i<10;i++) {
            collection.add(i);
        }

        System.out.println(collection);

        collection.removeIf(els -> (((int) els) % 2 == 0));

        System.out.println(collection);
    }

    public static void streamTest() {
        IntStream intStream = IntStream.builder()
                .add(1)
                .add(2)
                .add(3)
                .add(4)
                .add(5)
                .build();

        // 下面调用聚集方法的代码只能执行一次
        System.out.println("intstream中最大值：" + intStream.max().getAsInt());
        System.out.println("intstream中最小值：" + intStream.min().getAsInt());
        System.out.println("intstream和：" + intStream.sum());
        System.out.println("intstream元素个数：" + intStream.count());
        System.out.println("intstream元素的平均值：" + intStream.average());
        System.out.println("intstream元素是否均大于4：" + intStream.allMatch(ele -> (ele > 4)));
        System.out.println("intstream元素是否有大于4的： " + intStream.anyMatch(ele -> (ele > 4)));

        // 将intstream映射到另一个stream中
        IntStream intStream1 = intStream.map(ele -> (ele * 2));
        intStream1.forEach(System.out::println);
    }

    public static void main(String[] args) {
//        retriveCollection();
//        collectionTest();
//        collectionOperate();
        streamTest();
    }
}
