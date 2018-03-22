package ch08;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetDemo {
    /*
    * set 和 collection基本一样，但是set不允许有重复的元素
    * */

    public static void hashsetDemo() {
        HashSet hashSet = new HashSet();
        for(int i=0;i<5;i++) {
            hashSet.add(i);
            if (i == 3) {
                hashSet.add(3);  // 不会被添加进去
            }
        }
        System.out.println("hashSet:" + hashSet);

        class A{
            public boolean equals(Object object) {
                return true;
            }
        }
        class B{
            public int hashCode() {
                return 1;
            }
        }
        class C{
            public boolean equals(Object object) {
                return true;
            }

            public int hashCode() {
                return 2;
            }
        }

        /*
        * HashSet集合判断两个元素相等的标准是两个对象通过equals()方法比较相等，并且两个对象的hashCode()方法返回值也相等*/
        HashSet hashSet1 = new HashSet();
        hashSet1.add(new A());
        hashSet1.add(new A());
        hashSet1.add(new B());
        hashSet1.add(new B());
        hashSet1.add(new C());
        hashSet1.add(new C());
        // hashSet1:[ch08.SetDemo$1B@1, ch08.SetDemo$1B@1, ch08.SetDemo$1C@2, ch08.SetDemo$1A@677327b6, ch08.SetDemo$1A@1540e19d]
        System.out.println("hashSet1:" + hashSet1);
    }

    public static void LinkedHashSetDemo() {
        /*
        * LinkedHashSet会维持插入顺序*/
        LinkedHashSet linkedHashSet = new LinkedHashSet();

        linkedHashSet.add("cuber");
        linkedHashSet.add("qiu");
        linkedHashSet.add("bobo");

        System.out.println(linkedHashSet);
    }

    public static void treeSetDemo() {
        TreeSet treeSet = new TreeSet();

        // 采用默认的排序方法
        treeSet.add(1);
        treeSet.add(9);
        treeSet.add(5);
        treeSet.add(10);
        treeSet.add(6);

        System.out.println(treeSet);
        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
        System.out.println(treeSet.lower(10));
        System.out.println(treeSet.higher(5));
        System.out.println(treeSet.headSet(5));  // 返回小于5的子集
        System.out.println(treeSet.tailSet(5)); // 返回大于或等于5的子集
        System.out.println(treeSet.subSet(4, 9));  // 返回4<= <=9的子集

        // 自定义排序方法

        class M{
            public int age;

            public M(int age) {
                this.age = age;
            }

            @Override
            public String toString() {
                return "M[age:"+age+"]";
            }
        }

        TreeSet treeSet1 = new TreeSet((obj1, obj2)->{
            M m1 = (M) obj1;
            M m2 = (M) obj2;
            return m1.age > m2.age ? -1 : m1.age < m2.age ? 1 : 0;
        }
                );
        treeSet1.add(new M(1));
        treeSet1.add(new M(2));
        treeSet1.add(new M(4));
        treeSet1.add(new M(3));
        System.out.println(treeSet1);

    }
    public static void main(String[] args) {
//        hashsetDemo();
//        LinkedHashSetDemo();
        treeSetDemo();
    }
}
