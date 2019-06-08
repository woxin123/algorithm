package com.example.base.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * @author mengchen
 * @time 18-12-23 下午3:28
 */
public class QuickSort {

    public static<T> void quickSort(T[] array, Comparator<T> comparator) {
        qSort(array, 0, array.length - 1, comparator);
    }

    private static<T> void qSort(T[] array, int left, int right, Comparator<T> comparator) {
        int pivot;
        while (left < right) {
            // 将数组一分为二，并计算出枢轴值pivote
            pivot = partition(array, left, right, comparator);
            qSort(array, left, pivot - 1, comparator);
//            qSort(array, pivot + 1, right, comparator);
            left = pivot + 1;
        }
    }


    private static<T> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static<T> int partition(T[] array, int left, int right, Comparator<T> comparator) {
        T pivotKey;
//        int mid = (left + right) >>> 2;
//        if (comparator.compare(array[left], array[right]) > 0) {
//            swap(array, left, right);
//        }
//        if (comparator.compare(array[mid], array[right]) > 0) {
//            swap(array, mid, right);
//        }
//        if (comparator.compare(array[mid], array[left]) > 0) {
//            swap(array, mid, left);
//        }
        pivotKey = array[left];
        // 核心
        while (left < right) {
            while (left < right && comparator.compare(array[right], pivotKey) >= 0) {
                right--;
            }
            array[left] = array[right];
            while (left < right && comparator.compare(array[left], pivotKey) <= 0) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = pivotKey;
        return left;
    }


    public static void qSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }

        /**
         * 工作指针
         * p 指向序列左边等于piovt元素的位置
         * q 指向序列右边等于pivot元素的位置
         * i 指向从左向右扫描时的元素
         * j 指向从右向左扫描是的元素
         */
        int p, q, i, j;
        int pivot; // 锚点
        i = p = left;
        j = q = right - 1;
        /**
         * 每次总是取序列最右边的元素作为锚点
         */
        pivot = a[right];

        while (true) {
            /*
             * 工作指针i从左不断扫描，找小于或等于锚点元素的值
             */
            while (i < right && a[i] <= pivot) {
                /*
                 * 找到与锚点元素相同的元素将其交换到p所指示的位置
                 */
                if (a[i] == pivot) {
                    swap(a, i, p);
                    p++;
                }
                i++;
            }
            /*
             * 工作指针j从左向右不断扫描，找大于或等于锚点元素的元素
             */
            while (left <= j && a[j] >= pivot) {
                if (a[j] == pivot) {
                    swap(a, j, q);
                    q--;
                }
                j--;
            }

            // 如果两个工作
            // 如果两个工作指针i, j相遇则一趟结束
            if (i >= j) {
                break;
            }
            // 将左边大于pivot的元素与右边小于pivot元素进行交换
            swap(a, i, j);
            i++;
            j--;
        }
        /*
         * 因为工作指针i指向的是当前需要处理元素的下一个元素
         * 故因而需要推后到当前元素的实际位置，然后将等于pivot元素交换到中间
         */
        i--;
        p--;
        while (p >= left) {
            swap(a, i, p);
            i--;
            p--;
        }

        /*
         * 因为工作指针j指向是当前需要处理元素的上一个元素
         * 故而需要退回到当前元素的实际位置，然后将等于pivot元素交换到中间
         */
        j++;
        q++;
        while (q <= right) {
            swap(a, j, q);
            j++;
            q++;
        }

        /*
         * 递归遍历左右子序列
         */
        qSort(a,  left, i);
        qSort(a, j, right);
    }

    public static void quickSort(int[] array) {
        qSort(array, 0, array.length - 1);
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[10000000];
        Random random = new Random();
        for (int i = 0; i < 10000000; i++) {
            array[i] = random.nextInt(1000000);
        }
        long start = System.nanoTime();
        quickSort(array, Integer::compareTo);
        System.out.println(Arrays.toString(array));
        System.out.println((System.nanoTime() - start));
    }

}
