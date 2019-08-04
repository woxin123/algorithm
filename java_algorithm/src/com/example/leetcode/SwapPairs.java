package com.example.leetcode;

import com.example.leetcode.util.ListNode;

/**
 * @author mengchen
 * @time 18-12-4 下午4:28
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = null;
        ListNode q = null;
        ListNode pre = head;
        ListNode per = null;
        if (head.next != null) {
            p = head.next;
            if (p.next != null) {
                q = p.next;
            }
            p.next = head;
            head.next = q;
            head = p;
        }
        if (q == null) {
            return head;
        }
        pre = head.next;
        per = pre.next;
        while (per != null && per.next != null) {
            p = per;
            q = p.next;
            per = q.next;
            pre.next = q;
            q.next = p;
            p.next = per;
            pre = p;
        }
        return head;
    }
}
