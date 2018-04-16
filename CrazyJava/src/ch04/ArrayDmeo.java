package ch04;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;

public class ArrayDmeo {
    // java 中定义和使用数组
    public static void defineArray() {
        // 静态初始化数组
        int[] sArr = new int[]{1, 2, 3, 4};
        // 动态初始化素组
        int[] dArr = new int[5];
        System.out.println(sArr.length);  // 4
        System.out.println(dArr.length);  // 5

        dArr = sArr;
        System.out.println(dArr.length);  // 4

        // 数组支持foreach循环
        for (int x : sArr) {
            System.out.print(x+" ");
        }
        System.out.println();

        // 多维数组
        int[][] mArr = new int[3][];
        // 把mArr当作成一维数组，遍历数组的每一个元素
        for (int[] aMArr : mArr) {
            System.out.println(aMArr);
        }
        // 初始化数组mArr的第一个元素
        mArr[0] = new int[2];
        mArr[0][1] = 6;
        for (int x : mArr[0]) {
            System.out.println(x);
        }
    }

    // 使用java8增强工具类Arrays
    public static void ArraysDemo() {
        int[] a1 = new int[]{1, 2, 3, 4, 5};
        int[] a2 = new int[]{1, 2, 3, 4, 5};
        // 数组a1和数组a2的长度以及每个元素依次相等
        System.out.println(Arrays.equals(a1, a2));
        // 复制数组a1
        int[] b = Arrays.copyOf(a1, 6);
        // 输出数组b的元素
        System.out.println(Arrays.toString(b)); // [1, 2, 3, 4, 5, 0]
        // 将数组b的第3个到第4个元素用-1填充
        Arrays.fill(b, 2, 5, -1);  //左闭又开
        System.out.println(Arrays.toString(b));  // [1, 2, -1, -1, -1, 0]
        // 对数组b的元素进行排序
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));  // [-1, -1, -1, 0, 1, 2]
    }

    public static void main(String[] args) {
        ArraysDemo();
    }
}
