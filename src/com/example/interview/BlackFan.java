package com.example.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author mengchen
 * @time 19-4-13 下午7:41
 */
public class BlackFan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int V = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        double[] c = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
            c[i] = (b[i] * 1.0) / a[i];
        }

        double min = Arrays.stream(c).min().getAsDouble();
        double mMax = 0;
        for (int i = 0; i < n; i++) {
            mMax += a[i] * min;
        }
        if (mMax > V) {
            double f = V;
            System.out.printf("%.4f", f);
        } else {
            System.out.printf("%.4f", mMax);
            System.out.println();
        }
    }

}
