package com.example.base.sort;

import java.util.Arrays;

/**
 * @author mengchen
 * @time 19-4-19 上午11:58
 */
public class HeapSort1 {

    public static void main(String[] args) {
        int[] array = new int[] {4 ,3,5,6,3,1,231, 453,123};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        // 构建大顶堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            // 从第一个非叶子结从下至上
            adjustHeap(array, i, array.length);
        }
        // 调整堆结构+交换堆顶元素与末尾元素
        for (int i = array.length - 1; i > 0; i--) {
            // 将堆顶元素与末尾元素进行交换
            swap(array, 0, i);
            // 重新对堆进行调整
            adjustHeap(array, 0, i);
        }
    }

    private static void adjustHeap(int[] array, int i, int length) {
        int temp = array[i];    // 先取出当前元素i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {    // 从i节点的左节点开始，也就是2i + 1处开始
            if (k + 1 < length && array[k] < array[k + 1]) {    // 如果左子节点小于右子节点，k指向右子节点
                k++;
            }
            if (array[k] > temp) {     // 如果子节点大于父节点，将子节点赋给父节点（不用进行交换）
                array[i] = array[k];
                i = k;
            } else {
                break;
            }

        }
        array[i] = temp;    // 将temp值放到最终的位置
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
