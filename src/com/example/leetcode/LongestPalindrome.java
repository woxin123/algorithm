package com.example.leetcode;

/**
 * @author mengchen
 * @time 18-11-4 下午5:04
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindrome2("ccc"));
    }

    /**
     * 暴力法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        if (s.length() <= 1) {
            return s;
        }
        int start = 0, maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                int temp1 = 0, temp2 = 0;
                for (temp1 = i, temp2 = j; temp1 < temp2; temp1++, temp2--) {
                    if (s.charAt(temp1) != s.charAt(temp2)) {
                        break;
                    }
                }
                // 下面的是比较成功的情况
                // 有两种情况 temp1 == temp2 abcba
                // temp1 > temp2 abccba
                if (temp1 >= temp2 && maxLength < j - i + 1) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }
        if (maxLength > 0) {
            return s.substring(start, start + maxLength);
        } else {
            return s.substring(0, 1);
        }
    }

    public String longestPalindrome2(String s) {
        final int length = s.length();
        int maxLength = 0;
        int start = 0;
        boolean[][] p = new boolean[50][50];
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                p[i][j] = false;
            }
        }
        for (int i = 0; i < length; i++) {
            p[i][i] = true;
            if (i < length - 1 && s.charAt(i) == s.charAt(i + 1)) {
                p[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // 子串的长度
        for (int len = 3; len <= length; len++) {
            // 子串起始地址
            for (int i = 0; i <= length - len; i++) {
                // 子串结束地址
                int j = i + len - 1;
                if (p[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    p[i][i] = true;
                    maxLength = len;
                    start = i;
                }
            }
        }
        if (maxLength >= 2) {
            return s.substring(start, start + maxLength);
        }
        return null;
    }


}
