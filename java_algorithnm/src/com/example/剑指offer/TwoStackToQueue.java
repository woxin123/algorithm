package com.example.剑指offer;

import java.util.Stack;

/**
 * 使用两个栈实现队列
 */
public class TwoStackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("队列为空");
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    public static void main(String[] args) {
        TwoStackToQueue queue = new TwoStackToQueue();
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop() + ", " + queue.pop());
    }
}

