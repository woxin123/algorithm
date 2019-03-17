package com.example.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author mengchen
 * @time 19-3-16 上午11:29
 */
public class MinimalCandies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while (n-- > 0) {
            int m = sc.nextInt();
            sc.nextLine();
            int[] ratings = new int[m];
            for (int i = 0; i < m; i++) {
                ratings[i] = sc.nextInt();
            }
            sc.nextLine();
            long[] left = new long[m];
            long[] right = new long[m];
            Arrays.fill(left, 1);
            Arrays.fill(right, 1);
            for (int i = 1; i < m + 1; i++) {
                if (ratings[i % m] > ratings[i - 1]) {
                    left[i] = left[i - 1] + 1;
                }
            }
            for (int i = ratings.length; i >= 0; i--) {
                if (ratings[i % m] > ratings[(i + 1) % m]) {
                    right[i % m] = right[(i + 1) % m] + 1;
                }
            }

            long res = 0;
            for (int i = 0; i < ratings.length; i++) {
                res += Math.max(left[i], right[i]);
            }
            System.out.println(res);
        }
    }
}
