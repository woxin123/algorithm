package com.example.leetcode;

/**
 * @author mengchen
 * @time 19-1-31 下午4:53
 */
public class Exist {

    // 方向
    private int[][] directions = new int[][]{
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}
    };

    int m, n;

    private boolean[][] visited;

    private boolean isIn(int x, int y) {
        if (x >= 0 && x < m && y >= 0 && y < n) {
            return true;
        }
        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int x, int y) {
        if (index == word.length() - 1) {
            return board[x][y] == word.charAt(index);
        }

        if (board[x][y] == word.charAt(index)) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + directions[i][0];
                int newY = y + directions[i][1];
                if (isIn(newX, newY) && !visited[newX][newY]
                        && searchWord(board, word, index + 1, newX, newY)) {
                    return true;
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Exist exist = new Exist();
        boolean e = exist.exist(new char[][]{
//                {'A','B','C','E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'}
                {'b', 'a'}
        }, "ab");
        System.out.println(e);
    }
}
