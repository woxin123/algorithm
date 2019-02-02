package com.example.leetcode;

import com.example.leetcode.util.ListNode;

/**
 * @author mengchen
 * @time 19-2-2 上午11:56
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode tailLeft = left;
        ListNode tailRight = right;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                tailLeft.next = p;
                tailLeft = p;
            } else {
                tailRight.next = p;
                tailRight = p;
            }
            p = p.next;
        }
        tailRight.next = null;
        tailLeft.next = right.next;

        return left.next;
    }

    public static void main(String[] args) {
        Partition partition = new Partition();
        ListNode head = ListNode.listFromIntegers(new int[]{1, 4, 3, 2, 5, 2});
        System.out.println(head);
        System.out.println(partition.partition(head, 3));
    }
}
