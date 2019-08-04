package com.example.剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mengchen
 * Create by 18-4-27
 */

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {

    public static void main(String[] args) {
        int a[][] = new int[][]{{1}, {2}, {3}, {4}, {5}};
        PrintMatrix p = new PrintMatrix();
        System.out.println(p.printMatrix(a));
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        if (m == 0) {
            return list;
        }
        for (int i = 0; i < (Math.min(n,m)-1)/2+1; i++) {
            int x = i;
            for (int j = x; j < m - x; j++) {
                list.add(matrix[x][j]);
            }
            x = m - i - 1;
            for (int j = i + 1; j < n - i; j++) {
                list.add(matrix[j][x]);
            }
            x = n - i - 1;
            for (int j = m - i - 2; j >= i && (n - i - 1 != i); j--) {
                list.add(matrix[x][j]);
            }
            x = i;
            for (int j = n - i - 2; j >= i + 1 && (m - i- 1 != i); j--) {
                list.add(matrix[j][x]);
            }
        }

        return list;
    }

}
