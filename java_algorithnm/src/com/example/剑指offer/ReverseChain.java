package com.example.剑指offer;

import com.example.leetcode.util.ListNode;

import java.util.List;

/**
 * @author: mengchen
 * Create by 18-4-25
 */
public class ReverseChain {

    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode next = null;
        ListNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
}
