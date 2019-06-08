package com.example.剑指offer;

/**
 * 数字在排序数组中出现的次数
 * @author mengchen
 * @time 19-4-3 下午10:26
 */
public class GetNumberOfK {

    public int GetNumberOfK(int[] array, int k) {
        int a = getFirstK(array, k, 0, array.length - 1);
        int b = getLastK(array, k, 0, array.length - 1);
        if (a == -1 || b == -1) {
            return 0;
        }
        return b - a + 1;
    }

    private int getFirstK(int array[], int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) >> 1;
        int midData = array[mid];
        if (midData == k) {
            if ((mid > 0 && array[mid - 1] != k)
                    || mid == 0) {
                return mid;
            } else {
                end = mid;
            }
        } else if (midData > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }

        return getFirstK(array, k, start, end);
    }

    int getLastK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        int midData = array[mid];
        if (midData == k) {
            if ((mid < array.length - 1 && array[mid + 1] != k)
                    || mid == array.length - 1) {
                return mid;
            } else {
                start = mid + 1;
            }
        } else if (midData > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }

        return getLastK(array, k, start, end);
    }

    public static void main(String[] args) {
        System.out.println(new GetNumberOfK().GetNumberOfK(
                new int[]{1, 3, 3, 3, 3, 4, 5}, 6
        ));
    }

}
