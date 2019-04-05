package com.example.剑指offer;

import java.util.ArrayList;

/**
 * 和为S的两个数字
 * @author mengchen
 * @time 19-4-5 下午1:32
 */
public class FindNumbersWithSum {
    /**
     * 左右指针
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int left = 0, right = array.length - 1, tmp;
        ArrayList<Integer> list = new ArrayList<>();
        while (left < right) {
            tmp = array[left] + array[right];
            if (sum == tmp) {
                list.add(array[left]);
                list.add(array[right]);
                return list;
            } else if (tmp < sum) {
                left++;
            } else {
                right--;
            }
        }
        return list;
    }
}
