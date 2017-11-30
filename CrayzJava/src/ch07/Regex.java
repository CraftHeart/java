package ch07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    /*
   * 4.2 Using regexes in java: Test for a Pattern
   * Problem: You're ready to get started using regular expression processing to beef up your Java code by testing to
   * see if a given pattern can match in a given string.
   * Solution: Use Java Regular Expression Package, java.util.regex
   * This API is large enough to require some explanation. The normal steps for regex matching in a production program
   * are:
   * 1. Create a Pattern by calling the static method Pattern.compile().
   * 2. Request a Matcher from the pattern by calling pattern.matcher(CharSequence)
   *   for each String you wish to look through
   * 3. Call (once or more) one of the finder methods in the resulting Matcher.
   *
   * 正则表达式定义了字符串的模式
   * 正则表达式可以用来搜索、编辑或处理文本
   * 正则表达式并不仅限于某一种语言，但是在每种语言中有细微的差别*/
    public void RESimple()
    {
        //定义以Q开始，
        String pattern = "^Q[^u]\\d+\\.";
        String[] input = {
                "QA777. is the next flight. It is on the time.",
                "Quack, Quack, Quack!"
        };
        Pattern p = Pattern.compile(pattern);

        for(String in:input)
        {
            boolean found = p.matcher(in).lookingAt();  // 尝试将从区域开头开始的输入序列与该模式匹配

            System.out.println("'" + pattern + "'" +
                    (found ? " matches '" : " doesn't match '") + in + "'");
        }

        // 捕获组：是把多个字符当一个单独单元进行处理的方法，它通过对括号内的字符分组来创建
        // 可以通过调用matcher对象的groupCount方法来查看表达式有多少个分组。
        // groupCount方法返回一个int值，表示Matcher对象当前有多个捕获组
        // 特殊的组：group(0),它总是代表整个表达式。该组不包括在groupCount的返回值中。
        String line = "This order was placed for QT3000! ok?";
        String pattern1 = "(\\D*)(\\d+)(.*)";
        // 创建Pattern对象
        Pattern r = Pattern.compile(pattern1);
        // 创建matcher对象
        Matcher m = r.matcher(line);
        System.out.println("Group Count: " + m.groupCount());
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("NO MATCH");
        }

        /*
        * start 和 end 方法*/
        {
            final String REGEX = "\\bcat\\b";
            final String INPUT = "cat   cat cat cattie cat";
            Pattern p1 = Pattern.compile(REGEX);
            Matcher m1 = p1.matcher(INPUT);
            int count = 0;

            while (m1.find()) // find()方法尝试查找与该模式匹配的输入序列的下一个子序列
            {
                count++;
                System.out.println("Match number " + count);
                System.out.println("start():" + m1.start());  // 返回以前匹配的初始索引
                System.out.println("end():" + m1.end());  // 返回最后匹配字符之后的偏移量
            }
        }

        /*matched 和 lookAt方法*/
        {

        }
    }

    public static void useRegular() {
        // Pattern对象可以多次重复使用
        Pattern pattern = Pattern.compile("a*b");
        Matcher matcher = pattern.matcher("aaaab");
        boolean b = matcher.matches();
        System.out.println(b);

        // 如果某一个正则表达式只用一次，可以直接使用Pattern类的静态方法matches()
        boolean b1 = Pattern.matches("a*b", "aaaaab");
    }

    public static void main(String[] args)
    {
        Regex re = new Regex();
        re.RESimple();
    }
}
