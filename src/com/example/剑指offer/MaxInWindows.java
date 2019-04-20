package com.example.剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author mengchen
 * @time 19-4-19 下午7:35
 */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> maxInWindows = new ArrayList<>();
        if (num.length >= size && size >= 1) {
            LinkedList<Integer> index = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                while (!index.isEmpty() && num[i] >= num[index.getLast()]) {
                    index.removeLast();
                }
                index.addLast(i);
            }

            for (int i = size; i < num.length; i++) {
                maxInWindows.add(num[index.getFirst()]);

                while (!index.isEmpty() && num[i] >= num[index.getLast()]) {
                    index.removeLast();
                }
                if (!index.isEmpty() && index.getFirst() <= (i - size)) {
                    index.removeFirst();
                }
                index.addLast(i);
            }
            maxInWindows.add(num[index.getFirst()]);
        }
        return maxInWindows;
    }

    public static void main(String[] args) {
        new MaxInWindows().maxInWindows(new int[]{2, 3, 4, 1, 6, 2, 5, 1}, 3);
    }
}
