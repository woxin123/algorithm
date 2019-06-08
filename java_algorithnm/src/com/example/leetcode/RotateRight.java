package com.example.leetcode;

import com.example.leetcode.util.ListNode;

/**
 * @author mengchen
 * @time 18-12-4 下午4:58
 */
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 0) {
            return head;
        }
        ListNode per = head;
        ListNode tail;
        int count = 1;
        while (per.next != null) {
            per = per.next;
            count++;
        }
        tail = per;
        tail.next = head;
        per = tail;
        for (int i = 0; i < count - k % count; i++) {
            per = per.next;
        }
        head = per.next;
        per.next = null;
        return head;
    }

    public static void main(String[] args) {
        RotateRight rotateRight = new RotateRight();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        System.out.println(rotateRight.rotateRight(listNode, 2).val);
    }

}
