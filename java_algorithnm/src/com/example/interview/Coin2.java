package com.example.interview;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author mengchen
 * @time 19-4-5 下午3:04
 */
public class Coin2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        Set<Long> countSet = new HashSet<>();
        long stop = n / 2;
        for (long i = 1; i <= stop; i++) {
            long result = i ^ (n - i);
            countSet.add(result);
        }
        System.out.println(countSet.size());
    }
}
