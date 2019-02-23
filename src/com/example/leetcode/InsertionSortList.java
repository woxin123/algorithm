package com.example.leetcode;

import com.example.leetcode.util.ListNode;

import java.util.LinkedList;

/**
 * 对链表进行插入排序 |对链表进行插入排序|插入排序|[InsertionSortList](InsertionSortList.java)|2019-02-23|
 * @author mengchen
 * @time 19-2-23 上午11:48
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        LinkedList l = new LinkedList();
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mHead = new ListNode(0);
        mHead.next = head;
        ListNode start = head.next;
        head.next = null;
        for (ListNode t = start; t != null; ) {
            ListNode p = mHead;
            ListNode node = t;
            t = t.next;
            node.next = null;
            while (p.next != null && p.next.val < node.val) {
                p = p.next;
            }
            if (p.next != null) {
                ListNode q = p.next;
                p.next = node;
                node.next = q;
            } else {
                p.next = node;
            }
        }
        return mHead.next;
    }

    public static void main(String[] args) {
        System.out.println(new InsertionSortList().insertionSortList(
                ListNode.listFromIntegers(new int[]{4, 2, 1, 3, 5, 3, 5, 3, 4, 5, 6})
        ));
    }
}
