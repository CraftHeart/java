package ch08;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {
    public static void listTest() {
        List books = new ArrayList();
        books.add("万历十五年");
        books.add("明朝那些事儿");
        books.add("中国历代政治得失");

        System.out.println(books);

        // 将新字符串对象插入到第二个位置
        books.add(1, "中国人史纲");

        for(int i=0;i<books.size();i++) {
            System.out.print(books.get(i)+" ");
        }
        System.out.println();

        // 删除第三个元素
        books.remove(2);
        System.out.println(books);

        // 判断元素在List中的位置
        System.out.println(books.indexOf("中国人史纲"));

        // 将第二个元素替换成新的字符串对象
        books.set(1, new String("国史大纲"));
        System.out.println(books);

        books.sort((o1,o2)->((String)o1).length() - ((String)o2).length());
        System.out.println(books);
        books.replaceAll(ele->(((String)ele).length()));
        System.out.println(books);
    }

    public static void listIteratorTest() {
        String[] books = {"万历十五年", "中国人史纲", "国史大纲", "明朝那些事儿"};
        List bookList = new ArrayList();
        for (String book : books) {
            bookList.add(book);
        }
        ListIterator listIterator = bookList.listIterator();

        System.out.println("---------正向迭代---------");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println("\n"+"---------反向迭代---------");
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous()+" ");
        }
    }
    public static void main(String[] args) {
//        listTest();
        listIteratorTest();
    }
}
