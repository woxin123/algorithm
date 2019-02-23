package com.example.leetcode.util;

/**
 * @author mengchen
 * @time 18-10-23 下午3:13
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode listFromIntegers(int[] nums) {
        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < nums.length; i++) {
            if (head == null) {
                head = new ListNode(nums[i]);
                tail = head;
            } else {
                tail.next = new ListNode(nums[i]);
                tail = tail.next;
            }

        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode p = this;
        sb.append("[");
        int count = 0;
        while (p.next != null) {
            sb.append(p.val + ", ");
            p = p.next;
            count++;
            if (count > 20) {
                break;
            }
        }
        sb.append(p.val + "]");
        return sb.toString();
    }
}
