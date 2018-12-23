package com.example.leetcode;

import java.util.HashSet;

/**
 * @author mengchen
 * @time 18-12-22 下午2:16
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> map = new HashSet(9 * 9 * 3);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                String x = "row" + board[i][j] + i;
                if (map.contains(x)) {
                    return false;
                }
                map.add(x);
                x =  "columns" + board[i][j] + j;
                if (map.contains(x)) {
                    return false;
                }
                map.add(x);

                x = "cell" + board[i][j] + ((i / 3) * 3 + j / 3);
                if (map.contains(x)) {
                    return false;
                }
                map.add(x);
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        // 记录某行，某位数字是否已经被摆放
        boolean[][] row = new boolean[9][10];
        // 记录某列，某位数字是否已经被摆放
        boolean[][] col = new boolean[9][10];
        // 记录某 3x3 宫格内，某位数字是否已经被摆放
        boolean[][] block = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (row[i][num] || col[j][num] || block[i / 3 * 3 + j / 3][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[i / 3 * 3 + j / 3][num] = true;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };
        IsValidSudoku isValidSudoku = new IsValidSudoku();
        System.out.println(isValidSudoku.isValidSudoku(board));
    }
}
