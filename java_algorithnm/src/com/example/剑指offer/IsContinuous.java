package com.example.剑指offer;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 扑克牌顺子
 * @author mengchen
 * @time 19-4-8 下午6:21
 */
public class IsContinuous {

    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 1) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        int numberOfZero = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (set.contains(numbers[i])) {
                return false;
            }
            if (numbers[i] != 0) {
                set.add(numbers[i]);
            } else {
                numberOfZero++;
            }
        }
        AtomicInteger numberOfGap = new AtomicInteger();

        // 统计数组中0出现的次数
        // 统计数组中的间隔数目
        set.stream().reduce((acc, item) -> {
            numberOfGap.addAndGet(item - acc - 1);
            return item;
        });
        return numberOfGap.get() <= numberOfZero;
    }

    public static void main(String[] args) {
        System.out.println(new IsContinuous().isContinuous(new int[]{1, 3, 0, 5, 0}));
    }

}
