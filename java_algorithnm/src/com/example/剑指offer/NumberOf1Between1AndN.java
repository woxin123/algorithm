package com.example.剑指offer;

/**
 * 整数中1出现的次数
 * @author mengchen
 * @time 19-3-28 上午9:41
 */
public class NumberOf1Between1AndN {

    public int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += getNumberOf1(i);
        }
        return sum;
    }

    private int getNumberOf1(int n) {
        int sum = 0;
        while (n != 0) {
            int a = n % 10;
            if (a == 1) {
                sum++;
            }
            n /= 10;
        }
        return sum++;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1Between1AndN().NumberOf1Between1AndN_Solution(10));
    }

}
