package com.example.剑指offer;

import java.util.Arrays;

/**
 * @author mengchen
 * @time 19-4-7 下午4:49
 */
public class PrintProbaility {
    public static final int MAX_VALUE = 6;

    static class Solution1 {
        public void printProbability(int number) {
            if (number < 1) {
                return;
            }

            int[][] pProbabilities = new int[2][MAX_VALUE * number + 1];
            int flag = 0;
            for (int i = 1; i <= MAX_VALUE; i++) {
                pProbabilities[flag][i] = 1;
            }
            System.out.println(Arrays.toString(pProbabilities[flag]));
            for (int i = 2; i <= number; i++) {
                for (int j = 0; j < i; j++) {
                    pProbabilities[1 - flag][j] = 0;
                }

                for (int j = i; j <= MAX_VALUE * i; j++) {
                    pProbabilities[1 - flag][j] = 0;
                    for (int k = 1; k <= j && k <= MAX_VALUE; k++) {
                        pProbabilities[1 - flag][j] += pProbabilities[flag][j - k];
                    }
                }
                System.out.println(Arrays.toString(pProbabilities[1 - flag]));
                flag = 1 - flag;
            }

            System.out.println(Arrays.toString(pProbabilities[flag]));
            int total = (int) Math.pow((double) MAX_VALUE, number);
            for (int i = number; i <= MAX_VALUE * number; i++) {
                double ratio = (double) pProbabilities[flag][i] / total;
                System.out.println(i + ": " + ratio);

            }
        }


        public static void main(String[] args) {
            new Solution1().printProbability(6);
        }
    }

    static class Solution2 {
        public void printProbability(int number) {
            if (number < 1) {
                return;
            }

            int maxSum = number * MAX_VALUE;
            int[] pProbability = new int[maxSum - number + 1];
            for (int i = number; i <= maxSum; i++) {
                pProbability[i - number] = 0;
            }
            probability(number, pProbability);

            int total = (int) Math.pow((double) MAX_VALUE, number);
            for (int i = number; i <= maxSum; i++) {
                double ratio = (double) pProbability[i - number] / total;
                System.out.println(i + ": " + ratio);

            }
        }

        private void probability(int number, int[] pProbability) {
            for (int i = 1; i < MAX_VALUE; i++) {
                probability(number, number, i, pProbability);
            }
        }

        /**
         * @param original     表示有几个骰子
         * @param current      当前的骰子的个数
         * @param sum          摇original - current个骰子朝上一面的大小
         * @param pProbability
         */
        private void probability(int original, int current, int sum, int[] pProbability) {
            if (current == 1) {
                pProbability[sum - original]++;
            } else {
                for (int i = 1; i < MAX_VALUE; i++) {
                    probability(original, current - 1, i + sum, pProbability);
                }
            }
        }

        public static void main(String[] args) {
            new Solution2().printProbability(15);
        }
    }
}
