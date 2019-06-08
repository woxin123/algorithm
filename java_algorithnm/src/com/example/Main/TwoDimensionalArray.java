package com.example.Main;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean find = new TwoDimensionalArray().Find(7, a);
        System.out.println(find);
    }

    public boolean Find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int high = array[i].length - 1;
            int low = 0;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (target > array[i][mid])
                    low = mid + 1;
                else if (target < array[i][mid])
                    high = mid - 1;
                else
                    return true;
            }
        }
        return false;
    }
}

