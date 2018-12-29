package com.example.leetcode;

/**
 * @author mengchen
 * @time 18-12-29 上午9:24
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length - 1; i++) {
            strs[i] = reverseString(strs[i]);
            sb.append(strs[i]).append(" ");
        }
        sb.append(reverseString(strs[strs.length - 1]));
        return sb.toString();
    }

    public String reverseString(String s) {
        char[] values = s.toCharArray();
        int n = values.length - 1;
        for (int i = (n - 1) >> 1; i >= 0; --i) {
            int j = n - i;
            char ci = values[i];
            char cj = values[j];
            values[i] = cj;
            values[j] = ci;
        }
        return new String(values);
    }
}
