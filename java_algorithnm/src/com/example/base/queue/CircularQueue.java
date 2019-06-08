package com.example.base.queue;

/**
 * @auther 孟晨
 * @date 2018/12/8 20:17
 */
public class CircularQueue<T> {
    private Object items[];
    private int head = 0;
    private int tail = 0;
    private int n;

    public CircularQueue(int capacity) {
        items = new Object[capacity];
        n = capacity;
    }

    public boolean enqueue(T item) {
        // 队列满了
        if (tail + 1 % n == head) {
            return false;
        }
        items[tail] = item;
        tail = tail + 1 % n;
        return true;
    }

    public T dequeue() {
        if (head == tail) {
            return null;
        }
        T res = (T) items[head];
        head = (head + 1) % n;
        return res;
    }
}
