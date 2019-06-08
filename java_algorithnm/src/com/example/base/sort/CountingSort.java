package com.example.base.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * 计数排序
 * @auther 孟晨
 * @date 2018/12/24 16:18
 */
public class CountingSort {

    public static void countingSort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return;
        }

        // 查找数据的范围
        int max = a[0];
        for (int i = 0; i < n; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        // 申请申请一个计数数组 c，下标大小 [0,max]
        int[] c = new int[max + 1];
        Arrays.fill(c, 0);

        // 计算每个元素的个数，放入 c 中
        for (int i = 0; i <= max; i++) {
            c[a[i]]++;
        }

        // 依次累加，通过这个计算出来index
        for (int i = 1; i <= max; i++) {
            c[i] = c[i - 1] + c[i];
        }

        // 临时数组 r，存储排序之后的结果
        int[] r = new int[n];

        // 计算排序的关键步骤
        for (int i = n - 1; i >= 0; --i) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        for (int i = 0; i < n; i++) {
            a[i] = r[i];
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int a[] = new int[100];
        for (int i = 0; i < 100; i++) {
            a[i] = random.nextInt(100);
        }
        countingSort(a);
        System.out.println(Arrays.toString(a));
    }
}
