package com.example.剑指offer;

import com.example.leetcode.util.ListNode;

/**
 * 链表中环的入口结点
 * @author mengchen
 * @time 19-4-17 下午10:47
 */
public class EntryNodeOfLoop {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode p;
        if ((p = hasCircle(pHead)) == null) {
            return null;
        }
        while (p != pHead) {
            p = p.next;
            pHead = pHead.next;
        }
        return p;
    }

    public ListNode hasCircle(ListNode listNode) {
        if (listNode == null) {
            return null;
        }

        ListNode fast = listNode;
        ListNode slow = listNode;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next = l.next.next.next;
        new EntryNodeOfLoop().EntryNodeOfLoop(l);
    }
}
