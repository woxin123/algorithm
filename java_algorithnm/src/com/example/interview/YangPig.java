package com.example.interview;

import java.util.Arrays;

/**
 * 考点：
 *  - 1. 数列
 *  - 2. 斐波那契
 *  - 3. 排序后的序号
 * @author mengchen
 * @time 19-4-12 下午8:54
 */
public class YangPig {
    static class Pair implements Comparable<Pair> {
        public int index;
        public int value;

        @Override
        public int compareTo(Pair o) {
            return o.value - this.value;
        }
    }
    static String calculate(int m, int k){
        String res = "";
        int[] array = new int[m];
        array[0] = 2;
        array[1] = 3;
        array[2] = 4;
        for (int i = 3; i < m; i++) {
            array[i] = array[i - 2] + array[i - 3];
        }
        res += array[m - 1] + ".";
        int a = 2;
        int b = 3;
        int year = 2020;
        while (true) {
            if (b >= m) {
                break;
            }
            int tmp = b;
            b = a + b;
            a = tmp;
            year++;
        }
        res += year + ".";
        for (int i = 0; i < m; i++) {
            array[i] = reverse(array[i]);
        }
        Pair[] pairs = new Pair[m];
        for (int i = 0; i < m; i++) {
            pairs[i] = new Pair();
            pairs[i].index = i;
            pairs[i].value = array[i];
        }
        Arrays.sort(pairs);
        res += ++pairs[k - 1].index;
        return res;
    }

    static int reverse(int n) {
        int res = 0;
        while (n != 0) {
            res *= 10;
            res += n % 10;
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculate(20, 3));
    }

}