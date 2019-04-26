package com.example.剑指offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author mengchen
 * @time 19-4-24 下午3:43
 */
public class GetLeastNumbers {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k > input.length || k == 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < input.length && i < k; i++) {
            queue.add(input[i]);
        }

        for (int i = k; i < input.length; i++) {
            Integer top = queue.peek();
            if (top > input[i]) {
                queue.remove(top);
                queue.add(input[i]);
            }
        }
        return new ArrayList<>(queue);
    }

}
