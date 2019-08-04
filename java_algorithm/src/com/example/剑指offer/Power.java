package com.example.剑指offer;

/**
 * @author mengchen
 * @time 19-5-6 下午7:59
 */
public class Power {

    static class Solution1 {
        public double Power(double base, int exponent) {
            return Math.pow(base, exponent);
        }
    }

    static class Solution2 {
        public double Power(double base, int exponent) {
            if (0.0 == base && exponent < 0) {
                return 0.0;
            }
            boolean flag = false;
            if (exponent < 0) {
                flag = true;
            }
            exponent = Math.abs(exponent);
            double result = 1.0;
            for (int i = 0; i <= exponent; i++) {
                result *= base;
            }
            return flag ? 1.0 / result : result;
        }
    }

    static class Solution3 {
        public double Power(double base, int exponent) {
            if (0.0 == base && exponent < 0) {
                return 0.0;
            }
            boolean flag = false;
            if (exponent < 0) {
                flag = true;
            }
            exponent = Math.abs(exponent);
            double result = 1.0;
            while (true) {
                if (exponent == 0) {
                    break;
                }
                if ((exponent & 1) == 1) {
                    result *= base;
                    if (exponent == 1) {
                        break;
                    }
                }
                exponent = exponent >> 1;
                result *= result;
            }
            return flag ? 1.0 / result : result;
        }

        public static void main(String[] args) {
            System.out.println(new Solution3().Power(2, 3));
        }
    }


}
