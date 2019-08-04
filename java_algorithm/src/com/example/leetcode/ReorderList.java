package com.example.leetcode;

import com.example.leetcode.util.ListNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 重排链表
 * @author mengchen
 * @time 19-2-22 下午1:25
 */
public class ReorderList {

    /**
     * 把链表后半段放在栈中
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        Stack<ListNode> stack = new Stack();
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode s = slow;
        ListNode tmp;
        while (s != null) {
            stack.push(s);
            tmp = s;
            s = s.next;
            tmp.next = null;
        }
//        slow.next = null;
        ListNode p = head;
        ListNode q;
        ListNode r;
        while (p != null && !stack.isEmpty()) {
            q = p.next;
            r = stack.pop();
            if (p == r) {
                break;
            }
            p.next = r;
            r.next = q;
            // 这里不知道为什么会OOM
            p = p.next.next;
//            p.next = stack.pop();

        }
    }

    public void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }
        LinkedList<ListNode> nodes = new LinkedList<>();
        ListNode p = head;
        while (p != null) {
            nodes.add(p);
            p = p.next;
        }

        while (!nodes.isEmpty()) {
            if (p == null) {
                p = nodes.pollFirst();
            } else {
                p.next = nodes.pollFirst();
                p = p.next;
            }
            p.next = nodes.pollLast();
            p = p.next;
        }
        if (p != null) {
            p.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.listFromIntegers(new int[]{1, 2, 3, 4, 5, 6});
        new ReorderList().reorderList(head);
        System.out.println(head);
    }

}
