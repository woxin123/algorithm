package com.example.剑指offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */

/**
 * 首先想到的是使用一个min记录最小的值，但是可能会在pop中出现问题
 * 所以可以利用一个最小值的找，每入栈一个元素，那么同事也入找一个最小的元素，然后出栈的时候也一起出栈
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        System.out.println(minStack.min());
        minStack.push(4);
        System.out.println(minStack.min());
        minStack.push(2);
        System.out.println(minStack.min());
        minStack.push(3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }

    private int min = Integer.MAX_VALUE;

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minstack = new Stack<>();

    public void push(int node) {
        if (node < min) {
            min = node;
        }
        stack.push(node);
        minstack.push(new Integer(min));
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minstack.pop();
            min = minstack.peek();
        }
    }

    public int top() {
        if(!stack.isEmpty()) {
            return stack.peek();
        }
        return Integer.parseInt(null);
    }

    public int min() {
        return min;
    }

}
