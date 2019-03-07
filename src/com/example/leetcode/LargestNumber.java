package com.example.leetcode;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author mengchen
 * @time 19-3-7 下午5:36
 */
public class LargestNumber {
//    public String largestNumber(int[] nums) {
//        String[] strs = new String[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//
//        }
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n, m, k;
//        n = sc.nextInt();
//        m = sc.nextInt();
//        k = sc.nextInt();
//        sc.nextLine();
//        String[] map = new String[n];
//        for (int i = 0; i < map.length; i++) {
//            map[i] = sc.nextLine();
//        }
//        int res = 0;
//        for (int i = 1; i < n - 1; i++) {
//            int p = 0;
//            int j;
//            int startI = 0;
//            int startJ = 0;
//            boolean flag = true;
//            for (j = 1; j < m - 1; j++) {
//                if (map[i].charAt(j) == '1' && map[i - 1].charAt(j) == '1'
//                && map[i + 1].charAt(j) == '1' && map[i].charAt(j + 1) == '1'
//                && map[i].charAt(j - 1) == '1') {
//                    if (flag) {
//                        startI = i;
//                        startJ = j;
//                        flag = false;
//                    }
//                    p++;
//                }
//                if (p >= k) {
//                    break;
//                }
//            }
//            res += (m - j - 1) * (n - 1 - i) * (startI - i - 1) * (startJ - i - 1);
//
//        }
//        System.out.println(res);
//    }
}
