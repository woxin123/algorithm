package com.example.leetcode;

import com.example.leetcode.util.ListNode;

/**
 * @author mengchen
 * @time 18-11-27 上午10:11
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode lastNode = head;
        ListNode curNode = head;
        for (int i = 0; i < n; i++) {
            lastNode = lastNode.next;
            if (lastNode == null) {
                return head.next;
            }
        }

        while (lastNode.next != null) {
            lastNode = lastNode.next;
            curNode = curNode.next;
        }
        curNode.next = curNode.next.next;
        return head;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();

        System.out.println(removeNthFromEnd.removeNthFromEnd(new ListNode(1), 1));
    }

}
