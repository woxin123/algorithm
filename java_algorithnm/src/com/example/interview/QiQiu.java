package com.example.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author mengchen
 * @time 19-3-9 下午8:28
 */
public class QiQiu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[] qiqius = new int[n];
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            qiqius[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for (int start = 0;  start < n - m; start++) {
            int minCurrent = 0;
            Set<Integer> flag = new HashSet<>();
            for (int i = start; i < n; i++) {
                if (qiqius[i] == 0) {
                    continue;
                }
                minCurrent++;
                flag.add(qiqius[i]);
                if (flag.size() == m) {
                    break;
                }
            }
            if (minCurrent == Integer.MAX_VALUE) {
                if (minCurrent < min) {
                    min = minCurrent;
                } else {
                    min = -1;
                }
                break;
            }
            if (minCurrent < min) {
                min = minCurrent;
            }
        }
        System.out.println(min);
    }


//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n, m;
//        n = scan.nextInt();
//        m = scan.nextInt();
//
//        int[] array = new int[n];
//        for (int i = 0; i < n; i++) {
//            array[i] = scan.nextInt();
//        }
//
//        System.out.println(slideWindow(array, m));
//    }
//
//    public static int slideWindow(int[] array, int m) {
//        int length = array.length;
//        Set<Integer> set = new HashSet<>();
//        int res = Integer.MAX_VALUE;
//        int i = 0, j = 0;
//        while (i < length && j < length) {
//            if (array[j] == 0) {
//                j++;
//                continue;
//            }
//
//            if (!set.contains(array[j])) {
//                set.add(array[j++]);
//            } else {
//                if (array[i] == array[j]) {
//                    i++;
//                }
//                j++;
//            }
//            if (set.size() == m) {
//                res = Math.min(res, j - i);
//            }
//        }
//        if (res == Integer.MAX_VALUE) {
//            return -1;
//        }
//        return res;
//    }
}
