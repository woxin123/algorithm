package com.example.leetcode;

import java.util.Arrays;

/**
 * 被围绕的区域
 * @author mengchen
 * @time 19-2-17 上午1:47
 */
public class Solve {

    int col, row;
    /**
     * 逆向思维
     * 首先把与边界相关联的点都标记出来，然后处理没有关联的，最后再还原标记
     * @param board
     */
    public void solve(char[][] board) {
        row = board.length;
        if (row == 0) {
            return;
        }
        col = board[0].length;

        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[row - 1][i] == 'O') {
                dfs(board, row - 1, i);
            }
        }

        for (int i = 1; i < row - 1; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][col - 1] == 'O') {
                dfs(board, i, col - 1);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= row || y >= col || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'Y';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };

        new Solve().solve(board);

        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

}
