package com.example.剑指offer;

/**
 * @author mengchen
 * @time 19-4-4 上午9:43
 */
public class FindNumsAppearOnce {

    /**
     * 任何而一个数字异或它自己都等于0
     * 两个不同的数字异或得到的结果中，必然后有一位的结果是1
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length == 0) {
            return;
        }
        int a = 0;
        for (int i = 0; i < array.length; i++) {
            a ^= array[i];
        }

        // a中第一个bit为1的位置
        int firstBit1 = findFirstBit1(a);

        num1[0] = num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if (isBit1(array[i], firstBit1)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }

    }

    int findFirstBit1(int num) {
        int indexBit = 0;

        while ((num & 1) == 0&& (indexBit < 32)) {
            num >>= 1;
            indexBit++;
        }
        return indexBit;
    }

    boolean isBit1(int num, int firstBit1) {
        num >>= firstBit1;
        return (num & 1) == 1;
    }
}
