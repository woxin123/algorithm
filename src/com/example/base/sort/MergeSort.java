package com.example.base.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 归并排序
 * 归并排序的时间复杂度为O(nlogn)
 * 归并排序是一种稳定的排序
 * @author mengchen
 * @time 18-12-20 下午1:40
 */
public class MergeSort {


    public static<T> void sort(T[] arr, Comparator comparator) {
        T[] temp = (T[]) new Object[arr.length];
        sort(arr, 0, arr.length - 1, temp, comparator);
    }

    private static<T> void sort(T[] arr, int start, int end, T[] temp, Comparator comparator) {
        if (start < end) {
            int mid = (start + end) >>> 1;
            sort(arr, start, mid, temp, comparator);
            sort(arr, mid + 1, end, temp, comparator);
            merge(arr, start, mid, end, temp, comparator);
        }
    }

    private static<T> void merge(T[] arr, int start, int mid, int end, T[] temp, Comparator comparator) {
        int i = start;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= end) {
            if (comparator.compare(arr[i], arr[j]) < 0) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }

        while (j <= end) {
            temp[t++] = arr[j++];
        }

        t = 0;

        while (start <= end) {
            arr[start++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 4, 3, 6, 5, 6, 4};
        MergeSort.sort(arr, (Comparator.comparingInt(o -> (Integer) o)));
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();
    }
}
