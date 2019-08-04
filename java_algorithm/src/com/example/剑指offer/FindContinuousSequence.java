package com.example.剑指offer;

import java.util.ArrayList;

/**
 * 和为S的连续正数序列
 * @author mengchen
 * @time 19-4-5 下午1:44
 */
public class FindContinuousSequence {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (sum < 3) {
            return list;
        }

        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        int curSum = small + big;

        while (small < middle) {
            if (curSum == sum) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    arrayList.add(i);
                }
                list.add(arrayList);
            }
            while (curSum > sum && small < middle) {
                curSum -= small;
                small++;
                if (curSum == sum) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int i = small; i <= big; i++) {
                        arrayList.add(i);
                    }
                    list.add(arrayList);
                }

            }
            big++;
            curSum += big;
        }
        return list;
    }


}
