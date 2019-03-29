package com.example.剑指offer;

import java.util.ArrayList;

/**
 * 把数组排成最小的数
 * @author mengchen
 * @time 19-3-29 上午9:34
 */
public class PrintMinNumber {

    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<>(numbers.length);

        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }

        list.sort((i1, i2) -> {
            String s1 = String.valueOf(i1);
            String s2 = String.valueOf(i2);
            return (s1 + s2).compareTo(s2 + s1);
        });

        StringBuilder sb = new StringBuilder();

        for (Integer i : list) {
            sb.append(i);
        }

        return sb.toString();
    }
}
