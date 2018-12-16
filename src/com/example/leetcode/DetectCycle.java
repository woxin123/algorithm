package com.example.leetcode;

import com.example.leetcode.util.ListNode;

import java.util.HashSet;

/**
 * @author mengchen
 * @time 18-12-16 下午3:02
 */
public class DetectCycle {

    /**
     * 使用hash表
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        // 判断是否为空
        if (head == null) {
            return null;
        }
        // 创建hash表
        HashSet<ListNode> hash = new HashSet<>();

        // 遍历
        ListNode p = head;
        while (p != null) {
            // 如果hash表中已经有p，则返回p
            if (hash.contains(p)) {
                return p;
            }
            // 添加p
            hash.add(p);
            p = p.next;
        }
        return null;
    }

    /**
     * 使用快慢指针
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        // 判断是否为空
        if (head == null || head.next == null) {
            return null;
        }
        // 快慢指针
        ListNode slow = head,
                fast = head;
        // 判断是否有环
        boolean hasCycle = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            ListNode p = head;
            while (p != slow) {
                p = p.next;
                slow = slow.next;
            }
            return p;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        DetectCycle detectCycle = new DetectCycle();
        ListNode head = new ListNode(1);
        ListNode  second = new ListNode(2);
        head.next = second;
//        ListNode third = new ListNode(0);
//        second.next = third;
//        ListNode fivth = new ListNode(-4);
//        third.next = fivth;
//        fivth.next = second;
        ListNode listNode = detectCycle.detectCycle(head);
        System.out.println(listNode);
    }

}
