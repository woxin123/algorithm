package com.example.剑指offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {
    public static void main(String[] args) {
        MoreThanHalfNum m = new MoreThanHalfNum();
        int a = m.MoreThanHalfNum_Solution1(new int[]{1,2,3,2,4,2,5,2,3});
        System.out.println(a);
    }

    /**
     * 第一种思路，排序
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        Arrays.sort(array);
        int middle = array[array.length / 2];
        int count = 0;
        for (int a : array) {
            if (a == middle)
                count++;
        }
        if ((float)count > (float) array.length / 2) {
            return middle;
        } else {
            return 0;
        }
    }

    /**
     * 基于HashMap
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution1(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : array) {
            if (!map.containsKey(a)) {
                map.put(a, 1);
            } else {
                int count = map.get(a);
                map.put(a, ++count);
            }
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            Integer key = (Integer)  entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (val > array.length / 2) {
                return key;
            }
        }
        return 0;
    }
}
