package com.example.剑指offer;
import com.example.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值
 */
public class TailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        LinkedList<Integer> temp = new LinkedList<>();
        ListNode p;
        ListNode q;
        p = listNode;
        while (listNode != null) {
            q = p.next;
            temp.addFirst(p.val);
            p = q;
        }

        return new ArrayList<>(temp);
    }
}
