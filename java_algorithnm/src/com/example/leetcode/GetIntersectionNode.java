package com.example.leetcode;

import com.example.leetcode.util.ListNode;

import java.util.HashSet;

/**
 * @auther 孟晨
 * @date 2018/12/15 21:24
 */
public class GetIntersectionNode {

    /**
     * 使用哈希表
     * @param headA
     * @param headB
     * @return
     */
    /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        HashSet<ListNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = p.next;
        }
        p = headB;
        while (p != null) {
            if (set.contains(p)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }*/

    /**
     * 双指针
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA, pb = headB;

        while (pa != pb) {
            pa = (pa == null) ? headB : pa.next;
            pb = (pb == null) ? headA : pb.next;
        }
        return pa;
    }

}
