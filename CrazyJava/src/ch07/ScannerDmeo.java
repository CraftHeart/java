package ch07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerDmeo {
    // 使用Scanner类可以很方便地获取用户的键盘输入，Scanner是一个基于正则表达式的文本扫描器。
    /*
    * Scanner主要提供了两个方法扫描输入：
    * - hasNextXxx()：是否还有下一个输入项，其中Xxx可以是Int\Long等代表数据类型的字符串。
    * - nextXxx(): 获取下一个输入项。Xxx的含义与前一个方法中的Xxx相同。
    * 默认情况下，Scanner使用空白作为多个输入之间的分隔符。*/
    public static void ScannerTest() {
        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            System.out.println("键盘输入的内容是："+scanner.next());
//        }

//        while (scanner.hasNextLine()) {
//            System.out.println("键盘输入的一行的内容是："+scanner.nextLine());
//        }

        while (scanner.hasNextLong()) {
            long l = scanner.nextLong();
            System.out.println("Long is :" + l);
        }
    }

    public static void scannerFile() throws FileNotFoundException{
        Scanner scanner = new Scanner(new File("CrayzJava/src/ch07/file1.txt"));
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    public static void main(String[] args) throws Exception{
//        ScannerTest();
        scannerFile();
    }
}
