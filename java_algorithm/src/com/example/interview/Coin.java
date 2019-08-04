package com.example.interview;

import java.util.Scanner;

/**
 * @author mengchen
 * @time 19-3-9 下午7:32
 */
public class Coin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n, m;
        n = sc.nextLong();
        m = sc.nextLong();
        int count = 0;
        for (long i = n; i >= 1 && n != 0; i--) {
            long a = m % i;
            if (a == n) {
                continue;
            } else {
                count += m / i;
                m = m % i;
            }
        }
        System.out.println(count);
    }
}
