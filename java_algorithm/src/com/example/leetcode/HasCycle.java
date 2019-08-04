package com.example.leetcode;

import com.example.leetcode.util.ListNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @auther 孟晨
 * @date 2018/12/13 16:00
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> nodes = new HashSet<>();
        ListNode p = head;
        int count = 0;
        while (p != null) {
            count++;
            if (nodes.contains(p)) {
                return true;
            }
            nodes.add(p);
            p = p.next;
        }
        return false;
    }

    public boolean hasCycleTowPtr(ListNode head) {
        if (head == null || head.next ==  null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
