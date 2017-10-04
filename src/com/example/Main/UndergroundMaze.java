package com.example.Main;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 题目描述
 小青蛙有一天不小心落入了一个地下迷宫,小青蛙希望用自己仅剩的体力值P跳出这个地下迷宫。为了让问题简单,假设这是一个n*m的格子迷宫,
 迷宫每个位置为0或者1,0代表这个位置有障碍物,小青蛙达到不了这个位置;1代表小青蛙可以达到的位置。小青蛙初
 始在(0,0)位置,地下迷宫的出口在(0,m-1)(保证这两个位置都是1,并且保证一定有起点到终点可达的路径),小青蛙在
 迷宫中水平移动一个单位距离需要消耗1点体力值,向上爬一个单位距离需要消耗3个单位的体力值,向下移动不消耗
 体力值,当小青蛙的体力值等于0的时候还没有到达出口,小青蛙将无法逃离迷宫。现在需要你帮助小青蛙计算出能否
 用仅剩的体力值跳出迷宫(即达到(0,m-1)位置)。
 输入描述:
 输入包括n+1行:
 第一行为三个整数n,m(3 <= m,n <= 10),P(1 <= P <= 100)
 接下来的n行:
 每行m个0或者1,以空格分隔
 输出描述:
 如果能逃离迷宫,则输出一行体力消耗最小的路径,输出格式见样例所示;如果不能逃离迷宫,则输出"Can not escape!"。 测试数据保证答案唯一
 示例1
 输入

 4 4 10 1 0 0 1 1 1 0 1 0 1 1 1 0 0 1 1
 输出

 [0,0],[1,0],[1,1],[2,1],[2,2],[2,3],[1,3],[0,3]


 最短路径应该使用DFS
 */
public class UndergroundMaze {
    static int[][] map; // 地图
    static int mark[][];    // 标记该点是否走过，其中1为走过，0为没走过
    static int n, m;    // 地图大小
    static int P;       // 体力值
    static int hasenergy = 0;    // 找到路径是剩余的体力值
    static LinkedList<String> temp = new LinkedList<>();    // 暂存路径
    static LinkedList<String> path;     // 最终的路径
    static boolean isFind = false;      // 是否找到
    static int[][] step = new int[][]{{1, 0, 3}, {-1, 0, 0}, {0, 1, 1}, {0, -1, 1}};
    static ArrayDeque<Point> queue = new ArrayDeque<>();
    static class Point {
        public int x;
        public int y;
        public int enery;

        public Point(int x, int y, int enery) {
            this.x = x;
            this.y = y;
            this.enery = enery;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    // 获取输入流
        // 输入
        n = sc.nextInt();
        m = sc.nextInt();
        P = sc.nextInt();
        map = new int[n][m];
        mark = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        // DFS找路径
        BFS(0, 0, P);
//        if (isFind) {   // 找到了
//            for (int i = 0; i < path.size(); i++) {
//                if (i == path.size() - 1) {
//                    System.out.print(path.get(i));
//                    continue;
//                }
//                System.out.print(path.get(i) + ",");
//            }
//        } else {    // 没找到
//            System.out.println("Can not escape!");
//        }
        if (isFind) {   // 找到了
            for (int i = 0; i < queue.size(); i++) {
                if (i == queue.size() - 1) {
                    System.out.print("[" + queue.peek().x + "," + queue.poll().y + "]");
                    continue;
                }
                System.out.print("[" + queue.peek().x + "," + queue.poll().y + "],");
            }
        } else {    // 没找到
            System.out.println("Can not escape!");
        }
    }

    public static void DFS (int x, int y , int enery) {
        if (x >= 0 && x < n && y >= 0 && y < m && map[x][y] == 1 &&
                mark[x][y] == 0 &&enery >= 0) { // 满足坐标合法，能走，之前没走过，有体力值
            temp.add("[" + x + "," + y + "]");  // 加入暂存的路径
            mark[x][y] = 1;     // 标记该点走过
            if (x == 0 && y == m - 1) { // 找到出口
                if (enery >= hasenergy) {   // 可能会有多条路径，比较找到体力剩余最多的
                    hasenergy = enery;
                    path = new LinkedList<>(temp);  // 最终路径
                }
                // 回溯，遍历所有可能的路径，找到一条使用体力最少的路径。
                mark[x][y] = 0;
                temp.removeLast();
                isFind = true;
                return;
            } else {
                // 递归
                DFS(x + 1, y, enery);
                DFS(x - 1, y, enery - 3);
                DFS(x, y + 1, enery - 1);
                DFS(x, y - 1, enery - 1);
                // 回溯
                mark[x][y] = 0;
                temp.removeLast();
            }
        } else
            return;
    }

    public static void BFS(int x0, int y0, int sumEnergy) {
        queue.add(new Point(x0, y0, sumEnergy));
        while (!queue.isEmpty()) {
            int x = queue.peek().x;
            int y = queue.peek().y;
            int energy = queue.poll().enery;
            for (int i = 0; i < step.length; i++) {
                if (x + step[i][0] >= 0 && x + step[i][0] < n && y + step[i][1] >= 0 &&
                        y + step[i][1] < m && map[x + step[i][0]][y + step[i][1]] == 1 &&
                        mark[x + step[i][0]][y + step[i][1]] == 0 && energy - step[i][2] >= 0) {
                    int curX = x + step[i][0];
                    int curY = y + step[i][1];
                    int curEnergy = energy - step[i][2];
                    System.out.println(curX + " " + curY);
                    mark[curX][curY] = 1;
                    queue.push(new Point(curX, curY, curEnergy));
                    if (curX == 0 && curY == m - 1) {
                        isFind = true;
                        return;
                    }
                }
            }
            mark[x][y] = 0;
        }
    }
}
