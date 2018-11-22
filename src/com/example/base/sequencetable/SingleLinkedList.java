package com.example.base.sequencetable;

/**
 * 单链表
 * @author mengchen
 * @time 18-11-22 下午8:26
 */
public class SingleLinkedList<T> {

    /**
     * 头结点
     */
    private Node head;

    private int size;

    public SingleLinkedList() {
        head = new Node();
        size = 0;
    }

    /**
     * 链表的节点
     */
    private class Node {
        T data;
        Node next;

        Node() {

        }
        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 新增节点
     * @param item
     */
    public void add(T item) {
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node(item, null);
        size++;
    }

    /**
     * 在第i个位置插入data
     * @param index
     * @param data
     */
    public void add(int index, T data) {
        checkRange(index);
        if (index == size - 1) {
            add(data);
        } else {
            Node p = getNodeFromIndexBefore(index);
            Node q = p.next;
            p.next = new Node(data, q);
            size++;
        }
    }

    public T set(int index, T data) {
        Node p = getNodeFromIndexBefore(index);
        p = p.next;
        T oldValue = p.data;
        p.data = data;
        return oldValue;
    }

    public boolean containts(T data) {
        Node p = head.next;
        while (p != null) {
            if (p.data == data || p.data.equals(data)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    public T get(int index) {
        checkRange(index);
        Node p = head.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        if (p != null) {
            return p.data;
        }
        return null;
    }

    private Node getNodeFromIndexBefore(int index) {
        checkRange(index);
        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p;
    }

    public boolean remove(int index) {
        Node p = getNodeFromIndexBefore(index);
        if (p.next.next != null) {
            p.next = p.next.next;
        } else {
            p.next = null;
        }
        size--;
        return true;
    }

    /**
     * 链表逆置
     */
    public void reverse() {
        Node p = head.next;
        Node q = null;
        while (p != null) {
            head.next = p;
            p = p.next;
            head.next.next = q;
            q = head.next;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void checkRange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引位置不合理 index=" + index);
        }
    }


    private String listToString(String split) {
        StringBuilder sb = new StringBuilder();
        Node p = head.next;
        while (p.next != null) {
            sb.append(p.data).append(split);
            p = p.next;
        }
        sb.append(p.data);
        return sb.toString();
    }

    @Override
    public String toString() {
        return "[" + listToString(", ") + "]";
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        System.out.println(singleLinkedList.isEmpty());
        System.out.println(singleLinkedList.size);
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(4);
        singleLinkedList.add(5);
        singleLinkedList.add(2, 3);
        System.out.println(singleLinkedList.set(0, 100));
        System.out.println(singleLinkedList.get(0) + singleLinkedList.get(1));
        System.out.println(singleLinkedList.containts(0));
        System.out.println(singleLinkedList.remove(4));
        System.out.println(singleLinkedList);
        singleLinkedList.reverse();
        System.out.println(singleLinkedList.isEmpty());
        System.out.println(singleLinkedList.size);
        System.out.println(singleLinkedList);
        System.out.println(System.nanoTime() - start);
    }
}
