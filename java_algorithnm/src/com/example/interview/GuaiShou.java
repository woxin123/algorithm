package com.example.interview;

import java.util.Scanner;

/**
 * @author mengchen
 * @time 19-4-5 下午9:06
 */
public class GuaiShou {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        long[] li;
        int[] value;
        n = scanner.nextInt();
        li = new long[n];
        for (int i = 0; i < n; i++) {
            li[i] = scanner.nextInt();
        }

        value = new int[n];

        for (int i = 0; i < n; i ++) {
            value[i] = scanner.nextInt();
        }

        if (n == 1) {
            System.out.println(value[0]);
            return;
        }

        int needValue = value[0];
        long liSum = li[0];
        for (int i = 1; i < n; i++) {
            if (liSum < li[i]) {
                liSum += li[i];
                needValue += value[i];
            }
        }

        System.out.println(needValue);
    }

}
