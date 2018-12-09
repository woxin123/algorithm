package com.example.leetcode;

import com.example.leetcode.util.ListNode;

/**
 * 全排列
 *
 * @auther 孟晨
 * @date 2018/12/6 16:40
 */

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        for (int i = 0; i < k; i++) {
            if (current == null) {
                return head;
            }
            current = current.next;
        }
        ListNode newHead = reverse(head, current);
        head.next = reverseKGroup(current, k);
        return newHead;
    }

    ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = tail;
        while (head != tail) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        head.next = next1;
        ListNode next2 = new ListNode(3);
        next1.next = next2;
        ListNode next3 = new ListNode(4);
        next2.next = next3;
        ListNode next4 = new ListNode(5);
        next3.next = next4;
        ListNode listNode = reverseKGroup.reverseKGroup(head, 2);
        while (listNode != null) {
            System.out.println(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}