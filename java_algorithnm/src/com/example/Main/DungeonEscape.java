package com.example.Main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 题目描述
 给定一个 n 行 m 列的地牢，其中 '.' 表示可以通行的位置，'X' 表示不可通行的障碍，牛牛从 (x0 , y0 ) 位置出发，遍历这个地牢，和一般的游戏所不同的是，他每一步只能按照一些指定的步长遍历地牢，要求每一步都不可以超过地牢的边界，也不能到达障碍上。地牢的出口可能在任意某个可以通行的位置上。牛牛想知道最坏情况下，他需要多少步才可以离开这个地牢。
 输入描述:
 每个输入包含 1 个测试用例。每个测试用例的第一行包含两个整数 n 和 m（1 <= n, m <= 50），表示地牢的长和宽。接下来的 n 行，每行 m 个字符，描述地牢，地牢将至少包含两个 '.'。接下来的一行，包含两个整数 x0, y0，表示牛牛的出发位置（0 <= x0 < n, 0 <= y0 < m，左上角的坐标为 （0, 0），出发位置一定是 '.'）。之后的一行包含一个整数 k（0 < k <= 50）表示牛牛合法的步长数，接下来的 k 行，每行两个整数 dx, dy 表示每次可选择移动的行和列步长（-50 <= dx, dy <= 50）
 输出描述:
 输出一行一个数字表示最坏情况下需要多少次移动可以离开地牢，如果永远无法离开，输出 -1。以下测试用例中，牛牛可以上下左右移动，在所有可通行的位置.上，地牢出口如果被设置在右下角，牛牛想离开需要移动的次数最多，为3次。
 示例1
 输入

 3 3
 ...
 ...
 ...
 0 1
 4
 1 0
 0 1
 -1 0
 0 -1
 输出

 3
 */
public class DungeonEscape {
    public static void main(String[] args) {
        int minStep = bfs();
        System.out.println(minStep);
    }
    static int bfs() {
        Scanner sc = new Scanner(System.in);
        // n,m是地牢的大小
        int n = sc.nextInt();
        int m = sc.nextInt();
        // map 存的是地牢的地图
        char[][] map = new char[n][m];
        // mark用于表示走到该地所走的步数
        int[][] mark = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            map[i] = str.toCharArray();
        }
        // 初始化mark，用-1表示没走过的点
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                mark[i][j] = -1; // 用-1表示该点未走
            }
        }
        // x0,y0表示起始点
        int x0 = sc.nextInt();
        int y0 = sc.nextInt();
        // 共有k总走法
        int k = sc.nextInt();
        int[] stepx = new int[k];
        int[] stepy = new int[k];
        for (int i = 0; i < k; i++) {
            stepx[i] = sc.nextInt();
            stepy[i] = sc.nextInt();
        }
        // 用一个队列存放坐标
        Queue<Point> queue = new LinkedList<>();
        mark[x0][y0] = 0;   // 初始化起始点的所走的步数
        queue.add(new Point(x0, y0));
        while (!queue.isEmpty()) {
            int startx = queue.peek().x;
            int starty = queue.poll().y;
            for (int i = 0; i < k; i++) {
                if (startx + stepx[i] >= 0 && startx + stepx[i] < n
                        && starty + stepy[i] >= 0 && starty + stepy[i] < m
                        && map[startx + stepx[i]][starty + stepy[i]] == '.'
                        && mark[startx + stepx[i]][starty + stepy[i]] == -1) {
                    int x = startx + stepx[i];
                    int y = starty + stepy[i];
                    mark[x][y] = mark[startx][starty] + 1;
                    queue.add(new Point(x, y));
                }
            }
        }
        // 找到最大的步数
        int max = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '.' && mark[i][j] == -1) {  // 说明有些点没有遍历到
                    flag = false;
                }
                max = Math.max(max, mark[i][j]);
            }
        }
        if (flag)
            return max;
        else
            return -1;
    }
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
