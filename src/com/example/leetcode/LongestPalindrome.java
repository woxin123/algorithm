package com.example.leetcode;

/**
 * @author mengchen
 * @time 18-11-4 下午5:04
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindrome3("abcba"));
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

    /**
     * 动态规划 带备忘录的自定向下的动态规划
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.trim().equals("")) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        final int length = s.length();
        int maxLength = 0;
        int start = 0;
        boolean[][] p = new boolean[1000][1000];
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                p[i][j] = false;
            }
        }
        for (int i = 0; i <= length; i++) {
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
                    p[i][j] = true;
                    maxLength = len;
                    start = i;
                }
            }
        }
        if (maxLength >= 2) {
            return s.substring(start, start + maxLength);
        } else {
            return String.valueOf(s.charAt(0));
        }
    }

    /**
     * 中心扩展算法
     * @param s
     * @return
     */
    public String longestPalindrome3(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}
