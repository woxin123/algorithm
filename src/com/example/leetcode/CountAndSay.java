package com.example.leetcode;

import java.util.Scanner;

/**
 * @auther 孟晨
 * @date 2018/12/24 11:51
 */
public class CountAndSay {
    private String[] cache = new String[30];

    public String countAndSay(int n) {
        cache[0] = "1";
        cache[1] = "11";
        cache[2] = "21";
        cache[3] = "1211";
        cache[4] = "111221";

        for (int i = 5; i < n; i++) {
            if (cache[i] != null) {
                continue;
            }
            cache[i] = "";
            int len = cache[i - 1].length();
            for (int j = 0; j < len; j++) {
                int count = 1;
                while (j < len - 1 && cache[i - 1].charAt(j) == cache[i - 1].charAt(j + 1)) {
                    count++;
                    j++;
                }
                cache[i] += count + "" + cache[i - 1].charAt(j);
                if (j == len) {
                    cache[i] += count + cache[i - 1].charAt(j - 1);
                    break;
                }
            }
        }
        return cache[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CountAndSay countAndSay = new CountAndSay();
        while (true) {
            int n = sc.nextInt();
            System.out.println(countAndSay.countAndSay(n));
        }
    }
}
