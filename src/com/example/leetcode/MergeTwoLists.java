package com.example.leetcode;

import com.example.leetcode.util.ListNode;

/**
 * @author mengchen
 * @time 18-12-4 下午4:05
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        while (l1 != null || l2 != null) {
            ListNode node = null;
            if (l2 == null) {
                node = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l1 == null) {
                node = new ListNode(l2.val);
                l2 = l2.next;
            }
            else if (l1.val > l2.val) {
                node = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                node = new ListNode(l1.val);
                l1 = l1.next;
            }
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

}
