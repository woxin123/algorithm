package com.example.leetcode;

/**
 * @auther 孟晨
 * @date 2019/1/20 20:14
 */
public class MyPow {
    /**
     * 要计算x的y次方，一般来说需要相乘y次x
     * 但是可以减少相乘的次数,例如x^4次方，那么就可以(x^2) * (x^2)
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        // return Math.pow(x, n);
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        double ret = 0;
        double tmp = myPow(x, n / 2);
        if (n < 0) {
            x = 1 / x;
        }
        // n & 1 == 1 表示n是奇数
        if ((n & 1) == 1) {
            ret = x * tmp * tmp;
        } else {
            ret = tmp * tmp;
        }
        return ret;
    }

    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double res = 1;
        long len = Math.abs((long) n);
        while (len != 0) {
            if ((len & 1) == 1) {
                res *= x;
            }
            x = x * x;
            len = len >> 1;
        }
        return n > 0 ? res : 1 / res;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(new MyPow().myPow2(2, i));

        }
    }
}
