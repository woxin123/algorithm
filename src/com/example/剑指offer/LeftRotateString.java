package com.example.剑指offer;

/**
 * 左旋转字符串
 * @author mengchen
 * @time 19-4-6 上午11:31
 */
public class LeftRotateString {

    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        int length = str.length();
        n = n % length;
        String s1 = str.substring(0, n);
        String s2 = str.substring(n, length);
        return s2 + s1;
    }

    public static void main(String[] args) {
        System.out.println(new LeftRotateString().LeftRotateString("abcXYZdef", 3));
    }

}
