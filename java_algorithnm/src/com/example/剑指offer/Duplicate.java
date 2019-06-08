package com.example.剑指offer;

/**
 * 数组中重复的数字
 * @author mengchen
 * @time 19-4-16 上午9:47
 */
public class Duplicate {

    /**
     * 可以使用hash表来做
     *
     * 我们可以重排这个数组，从头到为依次扫描这个数组中的每个数字。
     * 当扫描到下标为i的数字时，首先比较这个数字（用m表示）是不是等于i。
     * 如果是，接着扫描下一个数字，如果不是，再拿它和第m个数字进行比较。
     * 如果它和第m个数字相等，就找到了一个重复的数字（该数字在下标为i
     * 和m的位置都出现了）。如果它和第m个数字不相等，就把第i个数字和第
     * m个数字交换，把m放到属于它的位置。接下来重复这个比较、交换的过程，
     * 直到我们发现一个重复的数字。
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {

        if (numbers == null || length <= 0) {
            return false;
        }

        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] != i) {
               if (numbers[i] != numbers[numbers[i]]) {
                   int tmp = numbers[i];
                   numbers[i] = numbers[tmp];
                   numbers[tmp] = tmp;
               } else {
                   duplication[0] = numbers[i];
                   return true;
               }
            }
        }
        return false;
    }


}
