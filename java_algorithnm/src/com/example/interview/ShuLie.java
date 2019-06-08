package com.example.interview;

import java.util.Scanner;

/**
 * @author mengchen
 * @time 19-3-9 下午7:47
 */
public class ShuLie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int l, r, res;
        for (; q > 0; q--) {
            l = sc.nextInt();
            r = sc.nextInt();
            if (l % 2 == 0 && r % 2 == 0) {
                res = (r - l) / 2;
                System.out.println(l + res);
            } else if (l % 2 != 0 && r % 2 != 0) {
                res = -((r - l) / 2);
                System.out.println(-l + res);
            } else if (l % 2 == 0 && r % 2 != 0) {
                res = (r - l + 1) / 2;
                System.out.println(-res);
            } else {
                res = (r - l + 1) / 2;
                System.out.println(res);
            }
            sc.nextLine();
        }
    }
}
