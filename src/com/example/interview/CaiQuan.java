package com.example.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author mengchen
 * @time 19-3-9 下午8:14
 */
public class CaiQuan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = (long) (1e9 + 7);
        int n, s;
        long nn = 1, ss = 1;
        n = sc.nextInt();
        s = sc.nextInt();
        int[] array = new int[n];
        for (int i = n; i >= s; i--) {
            nn *= i;
        }
        for (int i = 1; i <= s; i++) {
            ss *= i;
        }
        int[] counts = new int[3];
        Arrays.fill(counts, 0);

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            counts[array[i]]++;
        }
        long res = (nn / ss) * 2;
        for (int i = 0; i < 3; i++) {
            if (counts[i] == 0) {
                continue;
            }
            res -= counts[i] - 1;
        }
        res = res % num;
        System.out.println(res);
    }
}
