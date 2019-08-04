package com.example.Main;

import java.util.Hashtable;

/**
 * @author mengchen
 * @time 19-4-10 上午8:28
 */
public class TestString {

    public static void main(String[] args) {
//        String s1 = new String("1") + new String("123");
//        String s2 = new String("1") + new String("2");
//        String s3 = new String("1") + new String("12");
//        String s4 = new String("1") + new String("12231");
//        String s5 = new String("a") + new String("90184");
//        String s6 = new String("2") + new String("190kb");
//
//        // 也会创建，但是会直接把这个对象放在常量池中
//        String str1 = "a" + "b";
//
//        // 创建一个对象
//        String str2 = new String("ab");
//        System.out.println(str2.intern() == str1);
//
//
//        System.out.println(s1.intern() == s1);
//        System.out.println(s2.intern() == s2);
//        System.out.println(s3.intern() == s3);
//        System.out.println(s4.intern() == s4);
//        System.out.println(s5.intern() == s5);
//        System.out.println(s6.intern() == s6);
        String str = new String("ma") + new String("in");
        System.out.println(str.intern() == str);
    }

}
