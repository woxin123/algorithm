package com.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈D
 * @author mengchen
 * @time 19-4-29 上午9:37
 */
public class MyStack {

    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        Queue<Integer> tempQueue = new LinkedList<>();
        tempQueue.offer(x);
        while (!queue.isEmpty()) {
            tempQueue.offer(queue.poll());
        }
        queue = tempQueue;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
