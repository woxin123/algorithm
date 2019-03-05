package com.example.leetcode;

/**
 * Excel表列序号
 * @author mengchen
 * @time 19-3-5 下午12:32
 */
public class TitleToNumber {
    public int titleToNumber(String s) {
        int res = 0;
        for (char ch : s.toCharArray()) {
            res *= 26;
            res += ch - 'A' + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new TitleToNumber().titleToNumber("ZY"));
    }
}
