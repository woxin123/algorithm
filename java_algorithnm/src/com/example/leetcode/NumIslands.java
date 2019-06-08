package com.example.leetcode;

/**
 * 岛屿的个数
 * @author mengchen
 * @time 19-3-16 上午10:22
 */
public class NumIslands {

    /**
     * dfs
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1') {
                    numIslandsDfs(grid, n, m, i, j);
                    count++;
                }
            }
        }
        return count;
    }


    public void numIslandsDfs(char[][] grid, int n, int m, int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = '2';
        numIslandsDfs(grid, n, m, x + 1, y);
        numIslandsDfs(grid, n, m, x - 1, y);
        numIslandsDfs(grid, n, m, x, y + 1);
        numIslandsDfs(grid, n, m, x, y - 1);
    }

}
