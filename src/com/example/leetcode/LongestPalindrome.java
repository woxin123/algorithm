package com.example.leetcode;

/**
 * @author mengchen
 * @time 18-11-4 下午5:04
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindrome("ccc"));
    }

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

}
