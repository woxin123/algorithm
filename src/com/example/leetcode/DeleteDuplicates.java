package com.example.leetcode;

import com.example.leetcode.util.ListNode;

/**
 * @author mengchen
 * @time 18-12-5 上午10:19
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q;
        ListNode pre = head;
        while (p != null && p.next != null) {
            q = p.next;
            if (p.val == q.val) {
                if (p == head) {
                    head = head.next;
                } else {
                    pre.next = q;
                }
                p = q;
                if (p.next == null) {
                    if (p == head) {
                        head = null;
                    } else
                        pre.next = null;
                    break;
                }
                while (p.next != null) {
                    q = p.next;
                    if (p.val == q.val) {

                        p.next = q.next;

                    } else {
                        break;
                    }
                }
                if (head == p) {
                    head = head.next;
                } else {
                    pre.next = p.next;
                }
                p = pre.next;
                continue;
            }
            pre = p;
            p = q;
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        int[] ints = new int[]{1, 1, 2, 2, 3, 3, 5};
        ListNode p = head;
        for (int i = 0; i < ints.length; i++) {
            p.next = new ListNode(ints[i]);
            p = p.next;
        }
        DeleteDuplicates d = new DeleteDuplicates();
        ListNode listNode = d.deleteDuplicates(head);

        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }


    }
}
