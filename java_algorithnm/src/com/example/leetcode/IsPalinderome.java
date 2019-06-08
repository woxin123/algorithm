package com.example.leetcode;

/**
 * 回文数
 * @author mengchen
 * @time 18-11-17 下午1:46
 */
public class IsPalinderome {
    /**
     * 字符串方式
      * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        if (str.length() == 1) {
            return true;
        }
        boolean flag = str.length() % 2 == 0;
        int l = 0, r = str.length() - 1;
        while (true) {
            if (str.charAt(l++) != str.charAt(r--)) {
                return false;
            }
            if (l >= r) {
                return true;
            }
        }
    }

    public boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x!= 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        IsPalinderome i = new IsPalinderome();
        System.out.println(i.isPalindrome(12231));
    }
}
