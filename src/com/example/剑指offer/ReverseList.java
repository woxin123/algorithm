package com.example.剑指offer;

import com.example.leetcode.util.ListNode;

/**
 * @author mengchen
 * @time 19-5-6 上午9:16
 */
public class ReverseList {

    static class Solution1 {
        public ListNode ReverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pre = null;
            ListNode next = null;
            while (head != null) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }

        public static void main(String[] args) {
            Solution1 solution1 = new Solution1();
            System.out.println(solution1.ReverseList(ListNode.listFromIntegers(new int[] {3,2,1})));
        }
    }

    static class Solution2 {
        public ListNode ReverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = ReverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }

}
