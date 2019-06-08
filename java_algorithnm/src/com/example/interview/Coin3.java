package com.example.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mengchen
 * @time 19-4-5 下午8:10
 */
public class Coin3 {
    public static void main(String[] args) {
        int n, m;
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        int[] array = new int[n + 1];
        int i, sum = 0, result = 0;
        for (i = 1; i <= n; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        if (array[1] != 1) {
            System.out.println(-1);
            return;
        }
        for(;;) {
            if (sum >= m) {
                System.out.print(result);
                return;
            }
            for (i = n; i >= 1; i--)
                if (array[i] <= sum + 1) {
                    sum += array[i];
                    result++;
                    break;
                }
        }
    }
}
