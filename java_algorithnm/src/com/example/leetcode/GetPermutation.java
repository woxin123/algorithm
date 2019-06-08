package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther 孟晨
 * @date 2019/1/23 12:42
 */
public class GetPermutation {
    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            list.add(i);
        int num = 0, f = 0;
        for (int i = 1; i < n; i++) {
            k -= (num - 1) * f;
            f = factorial[n - i];
            num = (int) Math.ceil((double) k / f);
            result.append(list.get(num - 1));
            list.remove(num - 1);
        }
        return result.append(list.get(0)).toString();
    }

    public static void main(String[] args) {
        GetPermutation getPermutation = new GetPermutation();
        System.out.println(getPermutation.getPermutation(3, 5));
    }
}
