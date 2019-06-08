package com.example.interview;

import java.util.Scanner;

/**
 * @author mengchen
 * @time 19-4-5 下午3:51
 */
public class ReverseShuLie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long res = m * n / 2;
        System.out.println(res);
    }
}
