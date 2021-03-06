package com.example.剑指offer;

/**
 * 题目：写一个函数，求两个整数之和，要求在函数体内不得使用加减乘除四则运算
 * @author mengchen
 * @time 19-4-14 下午10:26
 */
public class Add {


    /**
     * 例如：5 + 17 = 22
     * 可以分三步：
     *      第一步只做各位相加，不做进位，结果为12，5 + 7 = 12，取2，0+1=1
     *      第二步做进位，5 + 7有进位，进位的值是10
     *      第三步把前两步得到的结果加起来
     * 对于二进制 5+17  101+10001
     * 还是分三步：
     *      第一步 101 + 10001  -> 10100  相加不进位 这一步可以使用位运算中的异或代替， 1 1 -> 0, 0 1 -> 1, 1 0 -> 0, 0 0 -> 0
     *      第二步 101 + 10001  -> 10     只保留进位 这一步可以使用位运算中的与，因为1 1 -> 1 其余情况都为0，所以相加后向左移一位
     *      第三步 把前两步的结果相加 那么可以重复前两个步骤，直到没有进位，也就是第二步的结果为0
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        int sum, carry;

        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);

        return num1;
    }

}
