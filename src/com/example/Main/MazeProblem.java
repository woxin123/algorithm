package com.example.Main;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * 用栈完成的迷宫问题
 */
public class MazeProblem {
    static int n, m;
    static int map[][];
    static int mark[][];
    static int directions[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    static ArrayDeque<Point> stack = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        map= new int[m][n];
        mark = new int[m][n];
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = Integer.valueOf(line.charAt(j) - '0');
            }
        }
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[i].length; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
        mazeProblem();
        while (!stack.isEmpty()) {
            Point point = stack.getLast();
            stack.removeLast();
            System.out.print("(" + (point.x + 1) + "," +
                    (point.y + 1) + "," + point.direction + ")");
        }
    }
    public static void mazeProblem() {
        Point a = new Point(0, 0, 1);
        Point b;
        int count;
        while (a.x != m - 1 || a.y != n - 1) {
            for (count = a.direction; count <= 4; count++) {
                b = new Point();
                b.x = a.x + directions[count-1][0];
                b.y = a.y + directions[count-1][1];
                a.direction = count;
                if (b.x < 0 || b.x >= m || b.y < 0 || b.y >= n)
                    continue;
                if (map[b.x][b.y] == 0 && mark[b.x][b.y] == 0) {
                    stack.push(a);
                    mark[a.x][a.y] = 2;
                    a = b;
                    a.direction = 1;
                    break;
                }
            }
            if (count == 5) {
                a = stack.pop();
                mark[a.x][a.y] = 0;
                a.direction++;
            }
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(mark[i][j]);
//                }
//                System.out.println();
//            }
        }
        stack.push(a);
        stack.peek().direction = 0;
    }

    static class Point{
        int x;
        int y;
        int direction;

        public Point() {}
        public Point(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }
}
