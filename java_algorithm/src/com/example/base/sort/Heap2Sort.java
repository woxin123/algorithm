package com.example.base.sort;

import java.util.Arrays;

/**
 * @author mengchen
 * @time 19-4-27 下午10:06
 */
public class Heap2Sort {

    public static void main(String[] args) {
        int[] arr = new int[] {10,3,4,4,12,12};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjust(arr, 0, i);
        }
    }

    private static void adjust(int[] arr, int i, int length) {
        int temp = arr[i];

        for (int k = 2 * i + 1; k  < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[i] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }

        arr[i] = temp;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
