package com.example.leetcode;

import java.util.Arrays;

/**
 * 搜索二维矩阵
 * @author mengchen
 * @time 19-1-28 下午3:23
 */
public class SearchMatrix {

    /**
     * 缩影 + 二分
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][n - 1] < target) {
                continue;
            } else {
                int i1 = Arrays.binarySearch(matrix[i], target);
                if (i1 >= 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        System.out.println(searchMatrix.searchMatrix(new int[][] {
                {1, 3, 4},
                {5, 6, 7},
                {8, 9, 10}
        }, 3));
    }
}
