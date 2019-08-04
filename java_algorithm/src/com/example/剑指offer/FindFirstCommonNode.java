package com.example.剑指offer;

import com.example.leetcode.util.ListNode;

/**
 * 两个链表的第一个公共结点
 * @author mengchen
 * @time 19-4-2 上午8:28
 */
public class FindFirstCommonNode {

    /**
     * 统计两个链表的长度，让长的链表先走这两个链表长度的差
     * 然后两个链表一起向后走，遇到相同的就停止
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int l1 = getListLength(pHead1);
        int l2 = getListLength(pHead2);

        int dif = l1 - l2;
        ListNode pListLong = pHead1;
        ListNode pListShort = pHead2;
        if (l1 < l2) {
            dif = -dif;
            pListLong = pHead2;
            pListShort = pHead1;
        }

        for (int i = 0; i < dif; i++) {
            pListLong = pListLong.next;
        }

        while (pListLong != null && pListShort != null && pListLong != pListShort) {
            pListLong = pListLong.next;
            pListShort = pListShort.next;
        }

        return pListLong;
    }

    private int getListLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode p = new ListNode(1);
        p.next = new ListNode(2);
        p.next.next = new ListNode(0);
        ListNode q = new ListNode(3);
        ListNode q1 = new ListNode(4);
        p.next.next.next = q;
        q.next = q1;
        ListNode p1 = new ListNode(-1);
        p1.next = new ListNode(-2);
        p1.next.next = q;

        FindFirstCommonNode findFirstCommonNode = new FindFirstCommonNode();
        findFirstCommonNode.FindFirstCommonNode(p, p1);
    }

}
