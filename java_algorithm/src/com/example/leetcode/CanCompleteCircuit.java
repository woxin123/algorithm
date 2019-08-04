package com.example.leetcode;

/**
 * 加油站
 *
 * @author mengchen
 * @time 19-2-19 下午3:42
 */
public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int j = i;
            boolean flag = false;
            int gasSum = gas[i];
            do {
                gasSum -= cost[j];
                j = (j + 1) % (gas.length);
                if (gasSum < 0) {
                    flag = true;
                    break;
                }
                gasSum += gas[j];
            } while (i != j);
            if (!flag) {
                return i;
            }
        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int total = 0;
        int rest = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            rest += gas[i] - cost[i];
            if (total < 0) {
                start = i + 1;
                total = 0;
            }
        }
        return rest < 0 ? -1 : start % gas.length;
    }

    public static void main(String[] args) {
        System.out.println(new CanCompleteCircuit().canCompleteCircuit(
                new int[]{3, 3, 4},
                new int[]{3, 4, 4}
        ));
    }
}
