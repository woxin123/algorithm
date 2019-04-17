package com.example.剑指offer;

import com.example.leetcode.util.ListNode;

/**
 * 删除链表中重复的结点
 * @author mengchen
 * @time 19-4-17 下午12:02
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode pre = head;
        ListNode current = head.next;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                pre.next = current.next;
                current = current.next;
                continue;
            }
            pre = current;
            current = current.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        System.out.println(new DeleteDuplication().deleteDuplication(ListNode.listFromIntegers(new int[]{1,1,1,1,1,1})));
    }
}
