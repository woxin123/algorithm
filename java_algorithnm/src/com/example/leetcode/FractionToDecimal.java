package com.example.leetcode;

import java.util.*;

/**
 * 分数到小数
 * @author mengchen
 * @time 19-3-3 下午3:10
 */
public class FractionToDecimal {

    /**
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return String.valueOf(0);
        }
        if (denominator == 0) {
            return "Nan";
        }
        long x, y;
        StringBuilder sb = new StringBuilder();
        String flag = "";
        if (numerator < 0) {
            flag = "-";
            x = Math.abs((long) numerator);
        } else {
            x = numerator;
        }
        if (denominator < 0) {
            flag = flag.equals("-") ? "" : "-";
            y = Math.abs((long)denominator);
        } else {
            y = denominator;
        }
        long a = x % y;
        long integer = x / y;
        if (a == 0) {
            return flag + integer;
        }
        Map<Long, Integer> map = new HashMap<>();
        int cyclePos = -1;
        int count = 0;
        map.put(a, count++);
        while (a != 0 && cyclePos == -1) {
            a *= 10;
            sb.append(a / y);
            a = a % y;
            if (map.containsKey(a)) {
                cyclePos = map.get(a);
                break;
            }
            map.put(a, count++);
        }
        if (cyclePos == -1) {
            return flag + integer + "." + sb.toString();
        } else {
            StringBuilder res = new StringBuilder(flag + integer);
            res.append(".");
            res.append(sb.substring(0, cyclePos));
            res.append("(");
            res.append(sb.substring(cyclePos));
            res.append(")");
            return res.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new FractionToDecimal().fractionToDecimal(-1, -2147483648));
    }
}
