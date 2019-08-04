package com.example.leetcode;

/**
 * @author mengchen
 * @time 18-11-2 下午9:50
 */
public class MyAtoi {

    private static final String numbers = "0123456789";

    public int myAtoi2(String str) {
        // 去掉空格
        str = str.trim();

        if (str.equals("")) {
            return 0;
        }
        // 分隔获取第一个
        str = str.contains(" ") ? str.split(" ")[0] : str;
        int result = 0;
        boolean negative = false;
        int i = 0, len = str.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = str.charAt(0);
            // Possible leading "+" or "-"
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+') {
                    return 0;
                }
                // Cannot have lone "+" or "-"
                if (len == 1) {
                    return 0;
                }
                i++;
            }
            multmin = limit / 10;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(str.charAt(i++),10);
                if (digit < 0) {
                    return negative ? result : -result;
                }
                if (result < multmin) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result *= 10;
                if (result < limit + digit) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result -= digit;
            }
        } else {
            return 0;
        }
        return negative ? result : -result;
    }

    public int myAtoi1(String str) {
        // 去掉空格
        str = str.trim();

        if (str.equals("")) {
            return 0;
        }
        // 分隔获取第一个
        str = str.contains(" ") ? str.split(" ")[0] : str;
        int ints = 0;
        boolean flag = false;
        if (str.charAt(0) == '-') {
            flag = true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && (str.charAt(0) == '-' || str.charAt(0) == '+')) {
                continue;
            }
            if (numbers.contains(String.valueOf(str.charAt(i)))) {
                if (ints > Integer.MAX_VALUE / 10 || (ints == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                    return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }

                ints *= 10;
                ints += str.charAt(i) - '0';
            } else {
                return flag ? -ints : ints;
            }
        }
        return flag ? -ints : ints;
    }

    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi1("3.1415926"));
    }
}
