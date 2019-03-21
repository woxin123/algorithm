package com.example.leetcode;

import com.example.leetcode.util.ListNode;

/**
 * 移除链表元素
 * @author mengchen
 * @time 19-3-21 下午5:59
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode mHead = new ListNode(0);
        mHead.next = head;
        ListNode cur = mHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return mHead.next;
    }

}
