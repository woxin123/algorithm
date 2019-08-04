package com.example.base.dynamicprogramming;

/**
 * 硬币问题
 * 我们有面值为1元3元5元的硬币若干枚，如何用最少的硬币凑够11元？
 * 分析：
 * 1 求问题的最优解：最小的硬币数
 * 2 是否有子问题：f(n)表示的最少硬币数是是上一次拿时候的硬币数最少。
 * 注意：f(n)是n元的最小硬币数，最后一次可拿的硬币数为1,3,5 则下一步
 * 的最小硬币数为 f(n-vi) 它的状态变更不是按元数的，是按照上次拿的硬币钱目
 * 3 状态转移方程为 f(n)= min(f(n-vi)+1)
 * 4 边界问题(找到最后一个重复的问题) 这里
 * f(1)=1 ,f(2)=f(1)+f(1)=2 f(3)=min(1,f(2)+1)
 * f(4)=f(3)+1 f(5)=1
 * 5 从上往下分析问题，从下往上解决问题。
 *
 * @author mengchen
 * @time 18-10-9 上午11:57
 */
public class CoinProblem {

    public static int coinProblem1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (n == 3) {
            return 1;
        }
        if (n == 4) {
            return 2;
        }
        if (n == 5) {
            return 1;
        }
        int[] h = new int[] {1, 3, 5};
        int min = n;
        for (int i = 0; i < 3; i++) {
            int count = coinProblem1(n - h[i]) + 1;
            if (min > count) {
                min = count;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(coinProblem1(11));
    }
}
