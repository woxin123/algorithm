package com.example.base.dynamicprogramming;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 棋盘上AA点有一个过河卒，需要走到目标BB点。卒行走的规则：可以向下、或者向右。同时在棋盘上CC点有一个对方的马，该马所在的点和所有跳跃一步可达的点称为对方马的控制点。因此称之为“马拦过河卒”。
 *
 * 棋盘用坐标表示，AA点(0, 0)(0,0)、BB点(n, m)(n,m)(nn, mm为不超过2020的整数)，同样马的位置坐标是需要给出的。
 *
 * 现在要求你计算出卒从AA点能够到达BB点的路径的条数，假设马的位置是固定不动的，并不是卒走一步马走一步。
 *
 * 输入输出格式
 * 输入格式：
 * 一行四个数据，分别表示BB点坐标和马的坐标。
 *
 * 输出格式：
 * 一个数据，表示所有的路径条数。
 * 链接：https://www.luogu.org/problemnew/show/P1002
 * @author mengchen
 * @time 18-10-10 下午8:04
 */
public class 过河卒 {

    private static int bx, by;
    private static int cx, cy;
    private static int[][] hStep = new int[][]{
            {0, 1, -1, 2, -2, 1, -1, 2, -2},
            {0, 2, -2, 1, -1, -2, 2, -1, 1}};
    private static boolean[][] mark = new boolean[21][21];
    private static BigInteger[][] map = new BigInteger[21][21];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bx = sc.nextInt();
        by = sc.nextInt();
        cx = sc.nextInt();
        cy = sc.nextInt();
        hourseControll();

        for (int i = 0; i <= bx; i++) {
            for (int j = 0; j <= by; j++) {
//                if (i == 0 || j == 0) {
////                    if (mark[i][j]) {
////                        map[i][j] = new BigInteger("0");
////                    } else {
//                        map[i][j] = new BigInteger("1");
////                    }
//                } else {
                    map[i][j] = new BigInteger("0");
//                }
            }
        }
        map[0][0] = new BigInteger("1");
        for (int i = 0; i <= bx; i++) {
            for (int j = 0; j <= by; j++) {
                if (i != 0){
                    map[i][j] = map[i - 1][j];
                }
                if (j != 0){
                    map[i][j] = map[i][j].add(map[i][j - 1]);
                }
                if (mark[i][j]) {
                    map[i][j] = new BigInteger("0");
                }
            }
        }
        for (int i = 0; i <= bx; i++) {
            for (int j = 0; j <= by; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();

        }
        System.out.println(map[bx][by]);
    }

    private static void hourseControll() {
        for (int i = 0; i < 9; i++) {
            if (cx + hStep[0][i] >= 0 && cx + hStep[0][i] <= bx
                    && cy + hStep[1][i] >= 0 && cy + hStep[1][i] <= by) {
                mark[cx + hStep[0][i]][cy + hStep[1][i]] = true;
            }
        }
    }

}
