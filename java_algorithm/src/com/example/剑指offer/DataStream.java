package com.example.剑指offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * 大顶堆 中存储的数字需要小于小顶堆中的每一个数字
 * @author mengchen
 * @time 19-4-19 下午5:11
 */
public class DataStream {

    private PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);

    private PriorityQueue<Integer> min = new PriorityQueue<>();


    public void Insert(Integer num) {
        if (((max.size() + min.size()) & 1) == 0) {
            if (max.size() > 0 && num < max.peek()) {
                max.add(num);
                num = max.poll();
            }
            min.offer(num);
        } else {
            if (min.size() > 0 && min.peek() < num) {
                min.add(num);
                num = min.poll();
            }
            max.offer(num);
        }
    }

    public Double GetMedian() {
        int size = max.size() + min.size();
        if (size == 0) {
            return 0.0;
        }
        Double mid;
        if ((size & 1) == 1) {
            mid = min.peek() * 1.0;
        } else {
            mid = ((min.peek() + max.peek()) * 1.0) / 2;
        }
        return mid;
    }

    public static void main(String[] args) {
        DataStream dataStream = new DataStream();
        int[] array = new int[]{5, 2, 3, 4, 1, 6, 7, 0, 8};
        for (int i = 0; i < array.length; i++) {
            dataStream.Insert(array[i]);
            System.out.println(dataStream.GetMedian());
        }
    }

}
