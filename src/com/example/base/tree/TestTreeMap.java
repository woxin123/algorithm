package com.example.base.tree;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author mengchen
 * @time 18-11-11 下午2:11
 */
public class TestTreeMap {

    public static void main(String[] args) {
        TreeSet<Integer> tree = new TreeSet<>();
        int[] array = new int[]{12, 1, 9, 2, 0, 11, 7, 19, 4, 15, 18, 5, 14, 13, 10, 16, 6, 3, 8, 17};
        for (int i = 0; i < array.length; i++) {
            tree.add(array[i]);
        }
    }

}
