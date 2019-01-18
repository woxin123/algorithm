package com.example.leetcode;

import java.util.Arrays;

/**
 * 旋转图像
 * @auther 孟晨
 * @date 2019/1/18 16:09
 */
public class Rotate {

    /**
     * 将一层记录下来，然后旋转
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        // 1  2  3  4
        // 5  6  7  8
        // 9  10 11 12
        // 13 14 15 16
        int n = matrix.length;
        int start = 0, end = n - 1;
        for (int i = 0; i < n >> 1; i++) {
            int[] tmp = new int[(end - start + 1) * 4];
            int count = 0;
            for (int j = start; j <= end; j++) {
                tmp[count++] = matrix[start][j];
            }

            for (int j = start; j <= end; j++) {
                tmp[count++] = matrix[j][end];
            }

            for (int j = end; j >= start; j--) {
                tmp[count++] = matrix[end][j];
            }

            for (int j = end; j >= start; j--) {
                tmp[count++] = matrix[j][start];
            }

            count = 0;
            for (int j = start; j <= end; j++) {
                matrix[j][end] = tmp[count++];
            }

            for (int j = end; j >= start; j--) {
                matrix[end][j] = tmp[count++];
            }

            for (int j = end; j >= start; j--) {
                matrix[j][start] = tmp[count++];
            }

            for (int j = start; j <= end; j++) {
                matrix[start][j] = tmp[count++];
            }
            start++;
            end--;
        }
    }

    /**
     * 先按x轴翻转
     * @param matrix
     */
    public void rotateOther(int[][] matrix) {
        for (int i = 0; i < matrix.length >> 1; i++) {
            swap(matrix, i , matrix.length - i - 1);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void swap(int[][] matrix, int x, int y) {
        int[] tmp = matrix[x];
        matrix[x] = matrix[y];
        matrix[y] = tmp;
    }

    private void swap(int[][] matrix, int x, int y, int i, int j) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = tmp;
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int [][] m = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        rotate.rotateOther(m);
        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }

}
