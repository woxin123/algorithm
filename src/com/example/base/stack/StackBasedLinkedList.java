package com.example.base.stack;

/**
 * @author mengchen
 * @time 18-11-28 下午2:42
 */
public class StackBasedLinkedList<T> {

    private Node<T> top = null;

    public void push(T value) {
        Node newNode = new Node(value, null);
        // 判断栈是否为空
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public T pop() {
        if (top == null) {
            return null;
        }
        T value = top.getData();
        top = top.next;
        return value;
    }


    @Override
    public String toString() {
        Node<T> p = top;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (p != null) {
            T value = p.getData();
            sb.append(value + " ");
            p = p.next;
        }
        sb.append("]");
        return sb.toString();
    }

    static class Node<T> {
        private T data;
        private Node next;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        T getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        StackBasedLinkedList<Integer> stack = new StackBasedLinkedList<>();
        stack.push(2);
//        System.out.println(stack.pop());
        stack.push(3);
        System.out.println(stack);
    }

}
