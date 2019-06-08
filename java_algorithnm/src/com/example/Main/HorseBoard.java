package com.example.Main;
/**
 * 马踏棋盘
 */

import java.util.ArrayDeque;
import java.util.Scanner;

public class HorseBoard {
    static int m, n;
    static int[][] direction = {
            {-2, 1},
            {-1, 2},
            {1, 2},
            {2, 1},
            {2, -1},
            {1, -2},
            {-1, -2},
            {-2, -1}
    };
    static int[][] map = new int[8][8];

    static int step = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        map[m - 1][n - 1] = 1;
        ArrayDeque<Point> stack = new ArrayDeque();
        int count = 1;
        Point a = new Point(m - 1, n - 1, 0);
        Point b = null;
        int k;
        while (count != 64) {
            for (k = a.flag; k < 8; k++) {
                b = new Point();
                b.x = a.x + direction[k][0];
                b.y = a.y + direction[k][1];
                a.flag = k;
                if (b.x < 0 || b.x >= 8 || b.y < 0 || b.y >= 8) {
                    continue;
                }
                if (map[b.x][b.y] == 0) {
                    map[a.x][a.y] = count;
                    count++;
                    stack.push(a);
                    a = b;
                    a.flag = 0;
                    break;
                }
            }
            if (k == 8) {
                a = stack.pop();
                map[a.x][a.y] = 0;
                count--;
                a.flag++;
            }
        }
        map[a.x][a.y] = count;
//        jump(m - 1, n - 1, 2);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j] < 10)
                    System.out.print(" " + map[i][j] + " ");
                else
                    System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
//    static int jump(int x, int y, int tag) {
//        int i, xx, yy;
//        for (i = 0; i < 8; i++) {
//            xx = x + direction[i][0];
//            yy = y + direction[i][1];
//            if(xx >= 0 && xx < 8 && yy >= 0 && yy < 8 && map[xx][yy] == 0) {
//                map[xx][yy] = tag;
//                if (tag == 64) {
//                    return 1;
//                }
//                if (jump(xx, yy, tag + 1) == 1)
//                    return 1;
//                else
//                    map[xx][yy] = 0;
//            }
//        }
//        return 0;
//    }

}

class Point {
    int x;
    int y;
    int flag;

    public Point() {
    }

    public Point(int x, int y, int flag) {
        this.x = x;
        this.y = y;
        this.flag = flag;
    }
}
