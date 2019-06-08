package com.example.leetcode;

import com.example.leetcode.util.ListNode;

/**
 * @author mengchen
 * @time 19-2-2 上午11:44
 */
public class DeleteDuplicatesFromListNode {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head;
        ListNode node = head.next;
        while (node != null) {
            if (pre.val == node.val) {
                pre.next = node.next;
                node = node.next;
            } else {
                pre = node;
                node = node.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        DeleteDuplicatesFromListNode delete = new DeleteDuplicatesFromListNode();
        ListNode head = ListNode.listFromIntegers(new int[]{1, 4, 3, 2, 5, 2});
        System.out.println(head);
        System.out.println(delete.deleteDuplicates(head));
    }
}
