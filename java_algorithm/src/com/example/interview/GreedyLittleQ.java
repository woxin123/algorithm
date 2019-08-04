package com.example.interview;

import java.util.Scanner;

/**
 * @author mengchen
 * @time 19-4-5 下午4:26
 */
public class GreedyLittleQ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(searchMaxChocolate(m, n));
    }

    private static int sumChocolate(int num, int day) {
        int sum = 0;
        for (int i = 1; i <= day; i++) {
            sum = sum + num;
            num = (int) Math.ceil((double) num / 2);
        }
        return sum;
    }

    private static int searchMaxChocolate(int total, int day) {
        int first = 1;
        int last = total;
        int sum = 0;
        int mid = (first + last) / 2;

        if (day == total) {
            return 1;
        }

        while (first <= last) {
            sum = sumChocolate(mid, day);
            if (sum < total) {
                first = mid + 1;
            } else if (sum == total){
                return mid;
            } else {
                last = mid - 1;
            }

            mid = (first + last) / 2;
        }

        return mid;
    }

}
