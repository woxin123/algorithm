package com.example.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mengchen
 * @time 19-3-20 下午5:25
 */
public class HappyNum {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            set.add(n);
            n = getSum(n);
            if (set.contains(n)) {
                return false;
            }
        }
        return true;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int a = n % 10;
            sum += a * a;
            n = n / 10;
        }
        return sum;
    }

}
