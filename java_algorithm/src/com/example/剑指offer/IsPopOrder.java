package com.example.剑指offer;

import java.util.ArrayDeque;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是
 * 该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这
 * 两个序列的长度是相等的）
 */
public class IsPopOrder {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int i = 0, j = 0;
        try {
            while (i != popA.length) {
                if (!stack.isEmpty() && stack.peek() == popA[i]) {
                    System.out.println(stack.peek());
                    stack.pop();
                    i++;
                } else {
                    stack.push(pushA[j++]);
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{4, 3, 5, 1, 2};
        boolean isPopOrder = new IsPopOrder().IsPopOrder(a, b);
        System.out.println(isPopOrder);
    }
}
