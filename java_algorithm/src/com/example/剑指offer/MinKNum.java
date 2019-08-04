package com.example.剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author mengchen
 * @time 18-10-7 下午9:23
 */
public class MinKNum {
    public static void main(String[] args) {
        MinKNum minKNum = new MinKNum();
        ArrayList<Integer> integers = minKNum.GetLeastNumbers_Solution(new int[]{5, 2, 3, 4}, 3);
        System.out.println(integers);
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input.length < k) {
            return new ArrayList<>();
        }
        Arrays.sort(input);
        return (ArrayList<Integer>) Arrays.stream(Arrays.copyOfRange(input, 0, k)).boxed().collect(Collectors.toList());
    }
}
