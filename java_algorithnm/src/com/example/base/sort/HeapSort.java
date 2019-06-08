package com.example.base.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mengchen
 * @time 18-10-7 下午9:48
 */
public class HeapSort {

    public static void main(String[] args) {
        Integer[] array = sortBig(new Integer[]{1, 2, 3, 4, 5}, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j]);
        }
    }

    public static<T> T[] sortBig(T[] array, Comparator<T> comparator) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            headAdjust(array, i, array.length, comparator);
        }

        for (int j = array.length - 1; j > 0; j--) {
            swap(array, 0, j);
            headAdjust(array, 0, j, comparator);
        }
        return array;
    }

    private static<T> void headAdjust(T[] array, int s, int m, Comparator<T> comparator) {
        T temp = array[s];
        for (int i = 2 * s + 1; i < m;  i = i * 2 + 1) {
            if (i + 1 < m  && comparator.compare(array[i], array[i + 1]) < 0) {
                ++i;
            }
            if (comparator.compare(array[i], temp) > 0) {
                array[s] = array[i];
                s = i;
            } else {
                break;
            }
        }
        array[s] = temp;
    }

    private static<T> void swap(T[] array, int a, int b) {
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
