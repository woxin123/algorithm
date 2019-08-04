package com.example.base.sort;

import java.util.Arrays;

/**
 * @author mengchen
 * @time 19-4-19 下午10:07
 */
public class QuickSort1 {


    public void sort(int[] array) {
        if (array.length < 2) {
            return;
        }
        quickSort(array,0, array.length - 1);
    }

    public void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = position(array, start, end);
        quickSort(array, start, pivot);
        quickSort(array, pivot + 1, end);
    }

    public int position(int[] array, int start, int end) {
        int pivot = array[start];
        while (start < end) {
            while (start < end && array[end] >= pivot) {
                end--;
            }
            array[start] = array[end];
            while (start < end && array[start] <= pivot) {
                start++;
            }
            array[end] = array[start];
        }
        array[start] = pivot;
        return start;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,4,5,1,2};
        new QuickSort1().sort(a);
        System.out.println(Arrays.toString(a));
    }


}
