package com.example.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author mengchen
 * @time 19-4-5 下午4:06
 */
public class CardGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Long[] array = new Long[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextLong();
        }

        Arrays.sort(array, (o1, o2) -> {
            if (o1 > o2) {
                return -1;
            } else if (o1 < o2) {
                return 1;
            } else {
                return 0;
            }
        });
        int sum1 = 0, sum2 = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (flag) {
                sum1 += array[i];
            } else {
                sum2 += array[i];
            }
            flag = !flag;
        }

        System.out.println(Math.abs(sum1 - sum2));
    }
}
