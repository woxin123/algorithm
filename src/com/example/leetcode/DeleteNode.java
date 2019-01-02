package com.example.leetcode;

import com.example.leetcode.util.ListNode;

/**
 * 删除链表中的某个节点
 * @author mengchen
 * @time 19-1-2 下午8:55
 */
public class DeleteNode {


    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
