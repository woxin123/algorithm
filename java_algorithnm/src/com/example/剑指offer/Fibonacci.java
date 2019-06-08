package com.example.剑指offer;

/**
 * 斐波那契数列，简单题
 */
public class Fibonacci {
    public int Fibonacci(int n) {
        if (n == 1 || n == 2) 
            return 1;
        int a = 1, b = 1, c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
