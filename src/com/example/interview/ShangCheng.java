package com.example.interview;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author mengchen
 * @time 19-4-28 下午9:33
 */
public class ShangCheng {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        BigInteger prices[] = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextBigInteger();
        }
        BigInteger sum = new BigInteger("0");
        long num = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i].compareTo(prices[i - 1]) > 0)
                sum = sum.add(prices[i].subtract(prices[i - 1]));
            num++;
        }
        System.out.println(sum + " " + num * 2);
    }

}