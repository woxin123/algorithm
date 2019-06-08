package com.example.leetcode;

import com.example.leetcode.util.ListNode;

/**
 * 排序链表
 * @author mengchen
 * @time 19-2-24 上午11:14
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        return sortListHelp(head, null);
    }

    private ListNode sortListHelp(ListNode head, ListNode tail) {
        if (head == null || head.next == null) {
            return head;
        }
        // 快慢指针中终点
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        head = sortListHelp(head, null);
        newHead = sortListHelp(newHead, null);
        return mergeTwoLists(head, newHead);
    }

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
            } else if (l1.val > l2.val) {
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

    public static void main(String[] args) {
        ListNode head = ListNode.listFromIntegers(new int[]{5, 2, 3, 1, 4});

        head = new SortList().sortList(head);
        System.out.println(head);
    }
}
