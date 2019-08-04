package com.example.leetcode;

/**
 * 验证回文串 |验证回文串|无|[IsPalindrome](IsPalindrome.java)|2019-02-15|
 * @author mengchen
 * @time 19-2-15 下午4:52
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        int n = sb.length() - 1;
        for (int i = 0; i < sb.length() >> 1; i++) {
            if (sb.charAt(i) != sb.charAt(n - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsPalindrome().isPalindrome("0P"));
    }
}
