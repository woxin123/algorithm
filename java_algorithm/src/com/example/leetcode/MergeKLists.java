package com.example.leetcode;

import com.example.leetcode.util.ListNode;

/**
 * 合并K个排序的链表
 *
 * @author mengchen
 * @time 18-12-20 下午12:45
 */
public class MergeKLists {

    /**
     * 思想，利用归并排序的并的思想
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int n = lists.length;
        while (n > 1) {
            int k = n >>> 1;
            for (int i = 0; i < n >>> 2; i = i++) {
                lists[i] = mergeTwoList(lists[i], lists[i + k]);
            }
            n = k;
        }
        return lists[0];
    }


    private ListNode mergeTwoList(ListNode n1, ListNode n2) {
        ListNode head,
                p;
        if (n1 == null && n2 == null) {
            return  null;
        }
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        if (n1.val > n2.val) {
            head = n2;
            n2 = n2.next;
        } else {
            head = n1;
            n1 = n1.next;
        }
        p = head;
        while (n1 != null || n2 != null) {
            ListNode item = null;
            if (n1 == null) {
                while (n2 != null) {
                    p.next = n2;
                    p = n2;
                    n2 = n2.next;
                }
            } else if (n2 == null) {
                while (n1 != null) {
                    p.next = n1;
                    p = n1;
                    n1 = n1.next;
                }
            } else if (n1.val < n2.val) {
                item = n1;
                n1 = n1.next;
            } else {
                item = n2;
                n2 = n2.next;
            }
            p.next = item;
            p = item;
        }
        return head;
    }
}
