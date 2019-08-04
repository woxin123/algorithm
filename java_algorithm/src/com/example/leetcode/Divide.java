package com.example.leetcode;

/**
 * letcode 两书相除
 *
 * @auther 孟晨
 * @date 2018/12/8 21:30
 */
public class Divide {

    public int divide(int dividend, int divisor) {
        // 异或
        // a ^ b a、b相同为0，a、b不同为1
        // 因为负负得正，负正得负
        int sign = (divisor < 0) ^ (dividend < 0) ? -1 : 1;

        // 防止溢出所以使用long
        long did = Math.abs((long) dividend);
        long dis = Math.abs((long) divisor);
        if (did < dis) {
            return 0;
        }
        long result = 0;
        while (did >= dis) {
            long temp = dis;
            long mm = 1;
            while (did >= (temp << 1)) {
                temp <<= 1;
                mm <<= 1;
            }
            did -= temp;
            result += mm;
        }
        // 结果大于int型的最大值
        if (result > Integer.MAX_VALUE) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int) (result * sign);
    }

    public static void main(String[] args) {
        Divide divide = new Divide();
        System.out.println(divide.divide(-2147483648, -1));
    }
}
