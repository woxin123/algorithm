package com.example.base.queue;

/**
 * 基于数组的队列
 * @auther 孟晨
 * @date 2018/12/8 17:08
 */
public class ArrayQueue<T> {

    // 数组：items，数组大小：n
    private Object[] items;
    private int n;
    // head指向队头
    private int head = 0;
    // tail指向队尾
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new Object[capacity];
        n = capacity;
    }

    /*
    public boolean enqueue(T item) {
        // tail == n 表示队列已满
        if (tail == n) {
            return false;
        }
        items[tail] = item;
        ++tail;
        return true;
    }
    */
    public boolean enqueue(T item) {
        if (tail == n) {
            if (head == 0) {
                return false;
            }
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    // 出队
    public T dequeue() {
        if (head == tail) {
            return null;
        }
        return (T) items[head++];
    }
}
