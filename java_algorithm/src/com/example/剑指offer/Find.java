package com.example.剑指offer;
import java.util.Arrays;

/**
 * 二维数组查找
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author mengchen
 * @time 19-5-2 下午8:26
 */
public class Find {

    /**
     * 二分查找，这里取巧用了Arrays的API
     */
    static class Solution1 {
        public boolean Find(int target, int [][] array) {
            for (int i = 0; i < array.length; i++) {
                if (Arrays.binarySearch(array[i], target) >= 0) {
                    return true;
                }
            }
            return false;
        }
    }

    static class Solution2 {
        public boolean Find(int target, int[][] array) {
            int row = 0;
            int col = array[0].length - 1;
            while (row < array.length - 1 && col >= 0) {
                if (target == array[row][col]) {
                    return true;
                } else if (target > array[row][col]) {
                    row++;
                } else {
                    col--;
                }
            }
            return false;
        }
    }
    static class Solution3 {
      public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
          return false;
        }   
        for (int i = 0; i < array.length; i++) {
          boolean ver = binarySearch(array, target, i, true);
          boolean hor = binarySearch(array, target, i, false);
          if (ver || hor) {
            return true;
          }
        }
        return false;
      }
      public boolean binarySearch(int[][] array, int target, int start, boolean vertical) {
          int lo = start;
          int hi = vertical ? array.length : array[0].length;
          while (lo < hi) {
              int mid = (lo + hi) / 2;
              if (!vertical) {
                if (array[start][mid] < target) {
                  lo = mid + 1;
                } else if (array[start][mid] > target) {
                  hi = mid - 1;
                } else {
                  return true;
                }
              } else {
                if (array[mid][start] < target) {
                  lo = mid + 1;
                } else if (array[mid][start] > target) {
                  hi = mid - 1;
                } else {
                  return true;
                }
              }
          }
          return false;
      }
    }

    public static void main (String[] args) {
      Solution3 s3 = new Solution3();
      boolean res = s3.Find(7, new int[][] {{1,2,8,9}, {4,7,10,13}});
      System.out.println(res);
    }

}
