package ch08;

import java.sql.SQLSyntaxErrorException;

/**
 * Created by wsn on 2018/5/20.
 */

class Weeble {}
public class ArraySize {
    public static void main(String[] args) {
        Weeble[] a;
        Weeble[] b = new Weeble[5];
        Weeble[] c = new Weeble[4];

        for(int i=0; i<c.length; i++) {
            c[i] = new Weeble();
        }

        Weeble[] d = {new Weeble(), new Weeble(), new Weeble()};

//        System.out.println("a.length = " + a.length);  // 编译错误，会提示变量未初始化
        System.out.println("b.length = " + b.length);

        // 句柄在数组内部会自动初始化为null
        for(int i=0; i<b.length; i++) {
            System.out.println("b[" + i + "]= " + b[i]);
        }

        System.out.println("c.length = " + c.length);
        System.out.println("d.length = " + d.length);

        a=d;
        System.out.println("a.length = " + a.length);

        a = new Weeble[]{new Weeble(), new Weeble()};
        System.out.println("a.length = " + a.length);

        // 基础类型数组
        int[] e;
        int[] f = new int[5];
        int[] g = new int[4];

        for(int i = 0; i<g.length;i++) {
            g[i] = i * i;
        }
        int[] h = {11, 47, 93};

//        System.out.println("e.length = " + e.length);  // e没有初始化
        System.out.println("f.length = " + f.length);
        // 基础类型在数组内部会被初始化为0
        for(int i=0; i<f.length;i++) {
            System.out.println("f[" + i + "]= " + f[i]);
        }
        System.out.println("g.length = " + g.length);
        System.out.println("h.length = " + h.length);
        e = h;
        System.out.println("e.length = " + e.length);
        e = new int[]{1, 2};
        System.out.println("e.length = " + e.length);
    }
}

class IceCream {
    static String[] flav = {"Chocolate", "Strawberry",
            "Vanilla Fudge Swirl", "Mint Chip",
            "Mocha Almond Fudge", "Rum Raisin",
            "Praline Cream", "Mud Pie"};

    static String[] flavorSet(int n) {
        n = Math.abs(n) % (flav.length + 1);
        String[] results = new String[n];
        int[] picks = new int[n];

        for(int i=0; i<picks.length;i++) {
            picks[i] = -1;
        }

        for(int i=0;i<picks.length;i++) {
            retry:
            while (true) {
                int t = (int) (Math.random() * flav.length);

                for(int j=0; j<i; j++) {
                    if (picks[j] == t) {
                        continue retry;
                    }
                }
                picks[i] = t;
                results[i] = flav[t];
                break;
            }
        }

        return results;
    }

    public static void main(String[] args) {
        for(int i=0; i<20; i++) {
            System.out.println("flavorSet(" + i + ") = ");
        }
        String[] fl = flavorSet(flav.length);
        for(int j=0;j<fl.length;j++) {
            System.out.println("\t" + fl[j]);
        }
    }
}

