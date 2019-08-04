package com.example.classic.最长上升路径;

import java.util.*;

public class Main {
    
    private int[][] direction = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length ==  0) {
            return 0;
        }
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                cache[i][j] = dfs(matrix, cache, i, j);
                max = Math.max(max, cache[i][j]);
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int[][] cache, int x, int y) {
        if (cache[x][y] != 0) {
            return cache[x][y];
        }
        int res = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + direction[i][0];
            int ny = y + direction[i][1];
            if (nx < 0 || nx >= matrix.length || ny < 0 || ny >= matrix[0].length ||
                matrix[x][y] <= matrix[nx][ny]) {
                continue;
            }
            res = Math.max(dfs(matrix, cache, nx, ny) + 1, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] data = {
            {9,9,4},
            {6,6,8},
            {2,1,1}
        };
        Main main = new Main();
        System.out.println(main.longestIncreasingPath(data));
    }
}