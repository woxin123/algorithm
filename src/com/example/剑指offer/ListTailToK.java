package com.example.剑指offer;

/**
 * @author: mengchen
 * Create by 18-4-25
 */

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class ListTailToK {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) {
            return null;
        }
        int count = 1;
        ListNode p  = head;
        while (p.next != null) {
            p = p.next;
            count++;
        }
        if (count < k) {
            return null;
        }
        int j = count - k;
        p = head;
        for (int i = 0; i < j; i++) {
            p = p.next;
        }
        return p;
    }
}
