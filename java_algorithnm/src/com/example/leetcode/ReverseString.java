package com.example.leetcode;

/**
 * @author mengchen
 * @time 18-12-28 上午11:40
 */
public class ReverseString {
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
