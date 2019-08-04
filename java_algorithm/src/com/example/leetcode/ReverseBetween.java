package com.example.leetcode;

import com.example.leetcode.util.ListNode;

/**
 * 反转链表 II
 *
 * @author mengchen
 * @time 19-2-6 下午5:35
 */
public class ReverseBetween {
    /**
     * 把m = 1当做特殊情况
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head.next == null) {
            return head;
        }

        ListNode mNode = null;
        // 构造一个头结点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode nNext = null;
        ListNode mPre = null;

        ListNode p = dummyHead;
        for (int i = 0; i < m - 1; i++) {
            p = p.next;
        }
        mPre = p;
        mNode = p.next;
        for (int i = 0; i <= n - m; i++) {
            p = p.next;
        }
        nNext = p.next;

        p = mNode;
        mNode = nNext;
        ListNode q;
        q = mNode;
        ListNode item = p;
        while (item != nNext) {
            p = item;
            item = item.next;
            mNode = p;
            mNode.next = q;
            q = mNode;
        }

        mPre.next = mNode;
        return dummyHead.next;
    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 最终为m 的前一个节点
        ListNode mPre = dummyHead;
        // 最终为n 的后一个节点
        ListNode nNext = null;
        // 带反转的两点
        ListNode cur;
        ListNode next;
        for (int i = 0; i < m - 1; i++) {
            mPre = mPre.next;
        }

        cur = mPre.next;
        next = cur.next;

        for (int i = 0; i < n - m; i++) {
            // 进行反转
            nNext = next.next;
            next.next = cur;

            cur = next;
            next = nNext;
        }
        mPre.next.next = nNext;
        mPre.next = cur;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ReverseBetween reverseBetween = new ReverseBetween();
        ListNode head = ListNode.listFromIntegers(new int[]{3, 5});
        System.out.println(reverseBetween.reverseBetween(head, 1, 2));
    }
}
