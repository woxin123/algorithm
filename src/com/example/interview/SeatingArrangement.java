package com.example.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 360笔试题 座位安排
 *
 * 假设班主任需要为N名学生安排座位，现在有M张桌子，每张桌子可以供一名学生单独使用，也可以供两名学生使用，
 * 共用一张桌子的两名学生便被称为同桌，班主任为所有学生评估出淘气值，第i名学生的淘气值为Ai，如果同桌两人
 * 淘气值过高，便容易产生矛盾。那么班主任应该如何安排座位，使得淘气值之和最大的两名同桌，其淘气值尽可能小。
 *
 * 输入
 * 第一行包含两个整数N和M，1 <= M < n < 10^5且N <= M * 2
 * 第二行包含N个整数Ai到An，0 < Ai < 10^9。
 * （数字之间均以空格隔开）
 *
 * 输出
 * 输出淘气值之和最大的两名同桌，其淘气值之和尽可能的最小值。
 *
 * 样例输出
 * 5 3
 * 4 1 8 2 6
 *
 * 样例输出
 * 7
 *
 *
 *
 * @author mengchen
 * @time 19-3-7 下午10:19
 */
public class SeatingArrangement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n, m, result = 0;
        n = sc.nextLong();
        m = sc.nextLong();
        long[] a = new long[(int) n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        Arrays.sort(a);
        long left = n - 2 * m, right = m + left;
        left = n + left - 1;
        for (int i = 0; i < right; i++) {
            if (a[i] + a[(int) (left - i)] > result) {
                result = a[i] + a[(int) (left - i)];
            }
        }
        System.out.println(result);
    }
}
