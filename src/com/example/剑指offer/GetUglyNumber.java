package com.example.剑指offer;

/**
 * 丑数
 * @author mengchen
 * @time 19-3-30 下午2:27
 */
public class GetUglyNumber {
    /**
     * 用空间换时间
     * 这里的一个难点是数字的顺序问题
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {

        if (index <= 0) {
            return 0;
        }

        int p2, p3, p5;
        p2 = p3 = p5 = 0;

        int[] pUglyNumbers = new int[index];

        pUglyNumbers[0] = 1;
        int nextPUglyNumbers = 1;
        while (nextPUglyNumbers < index) {
            int min = min(pUglyNumbers[p2] * 2, pUglyNumbers[p3] * 3,
                    pUglyNumbers[p5] * 5);
            pUglyNumbers[nextPUglyNumbers] = min;
            while (pUglyNumbers[p2] * 2 <= pUglyNumbers[nextPUglyNumbers]) {
                ++p2;
            }
            while (pUglyNumbers[p3] * 3 <= pUglyNumbers[nextPUglyNumbers]) {
                ++p3;
            }
            while (pUglyNumbers[p5] * 5 <= pUglyNumbers[nextPUglyNumbers]) {
                ++p5;
            }
            ++nextPUglyNumbers;

        }
        return pUglyNumbers[index - 1];
    }

    int min(int number1, int number2, int number3) {
        int min = (number1 < number2) ? number1 : number2;
        min = (min < number3) ? min : number3;

        return min;
    }

    private boolean isUgly(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }

        return number == 1;
    }

    public static void main(String[] args) {
        System.out.println(new GetUglyNumber().GetUglyNumber_Solution(5));
    }
}
