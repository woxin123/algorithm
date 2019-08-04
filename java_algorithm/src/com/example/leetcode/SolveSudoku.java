package com.example.leetcode;

import java.util.Arrays;

/**
 * @author mengchen
 * @time 18-12-23 下午2:43
 */
public class SolveSudoku {

    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][] cell = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    row[i][num - 1] = true;
                    column[num - 1][j] = true;
                    cell[i / 3 * 3 + j / 3][num - 1] = true;
                }
            }
        }
        dfs(board, row, column, cell, 0, 0);
    }

    private boolean dfs(char[][] board, boolean[][] row,
                        boolean[][] cloumn, boolean[][] cell, int i, int j) {
        while (board[i][j] != '.') {
            if (++j >= 9) {
                i++;
                j = 0;
            }
            if (i >= 9) {
                return true;
            }
        }
        for (int k = 1; k <= 9; k++) {
            int cellNum = i / 3 * 3 + j / 3;
            if (!row[i][k - 1] && !cloumn[k - 1][j] && !cell[cellNum][k - 1]) {
                board[i][j] = (char) (k + '0');
                row[i][k - 1] = true;
                cloumn[k - 1][j] = true;
                cell[cellNum][k - 1] = true;
                if (dfs(board, row, cloumn, cell, i, j)) {
                    return true;
                } else {
                    // 回调
                    row[i][k - 1] = false;
                    cloumn[k - 1][j] = false;
                    cell[cellNum][k - 1] = false;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        SolveSudoku solveSudoku = new SolveSudoku();
        solveSudoku.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
