import java.util.*;
public class MaxSubArray {

    public static void main(String[] args) {
        MaxSubArray2 m = new MaxSubArray2();
        int max = m.maxSubArray(new int[]{1,2,3,4,5,6});
        System.out.println(max);
    }
}

/**
 * 暴力法
 */
class MaxSubArray1 {
    public int maxSubArray(int[] a) {
        int maxSum = a[0];
        int currSum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum += a[k];
                }
            }
            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }
        return maxSum;
    }

}

/**
 * 分治法
 */
class MaxSubArray2 {

    public int maxSubArray(int[] a) {
        return maxSubArray(a, 0, a.length - 1);
    }

    public int maxSubArray(int[] a, int from, int to) {
        if (from == to) {
            return a[from];
        }
        int middle = (from + to) / 2;
        int left = maxSubArray(a, from, middle);
        int right = maxSubArray(a, middle + 1, to);
        int lmax = a[middle], now = a[middle];
        for (int i = middle - 1; i >= from; i--) {
            now += a[i];
            if (now > lmax) {
                lmax = now;
            }
        }
        now = a[middle + 1];
        int rmax = now;
        for (int i = middle + 1; i <= to; i++) {
            now += a[i];
            if (now > rmax) {
                rmax = now;
            }
        }
        int mid = lmax + rmax;
        return Math.max(Math.max(left, right), mid);
    }

}
