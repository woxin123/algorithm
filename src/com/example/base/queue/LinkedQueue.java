package com.example.base.queue;

/**
 * @auther 孟晨
 * @date 2018/12/8 17:21
 */
public class LinkedQueue<T> {

    private Node<T> head = new Node();
    private Node<T> tail;

    private static class Node<T> {
        private T val;
        private Node previous;
        private Node next;

        Node(T val, Node previous, Node next) {
            this.val = val;
            this.previous = previous;
            this.next = next;
        }

        Node() {
        }
    }

    public boolean enqueue(T item) {

        Node newNode = new Node(item, null, null);
        newNode.next = this.head.next;
        if (this.head.next != null) {
            this.head.next.previous = newNode;
        } else {
            this.tail = newNode;
        }
        this.head.next = newNode;
        newNode.previous = this.head;
        return true;
    }

    public T dequeue() {
        if (tail == null) {
            return null;
        }
        T res = tail.val;
        tail = tail.previous;
        tail.next = null;
        return res;
    }

    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
