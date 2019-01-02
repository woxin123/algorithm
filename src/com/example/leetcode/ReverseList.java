package com.example.leetcode;

import com.example.leetcode.util.ListNode;

/**
 * @author mengchen
 * @time 19-1-2 下午9:01
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head, q, r;
        head = head.next;
        p.next = null;

        while (head != null) {
            r = head;
            head = head.next;
            q = p;
            p = r;
            p.next = q;
        }

        return p;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        ReverseList reverseList = new ReverseList();
        ListNode listNode1 = reverseList.reverseList(listNode);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }


}
