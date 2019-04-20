package com.example.leetcode;

/**
 * @author mengchen
 * @time 19-4-19 下午9:04
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] map = new int[matrix.length + 1][matrix[0].length + 1];

        int max = 0;
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    map[i][j] = 1 + Math.min(map[i - 1][j - 1], Math.min(map[i][j - 1], map[i - 1][j]));
                    max = Math.max(map[i][j], max);
                }
            }
        }
        return max * max;
    }

}
