package com.example.leetcode;

/**
 * 计数质数
 * @author mengchen
 * @time 19-3-28 上午9:14
 */
public class CountPrimes {

    /**
     * 厄拉多塞筛法
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        int array[] = new int[n];
        array[1] = 1;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (array[i] == 0) {
                for (int j = i * i; j < n; j += i) {
                    array[j] = 1;
                }
            }
        }

        int sum = 0;
        for (int i = 2; i < n; i++) {
            if (array[i] == 0) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(10));
    }

}
