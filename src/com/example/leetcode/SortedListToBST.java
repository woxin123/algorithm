package com.example.leetcode;

import com.example.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengchen
 * @time 19-2-8 下午3:06
 */
public class SortedListToBST {
    /**
     * 第一种先将链表转换成数组
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        return sortedArrayToBSTHelp(nums, 0, nums.size() - 1);
    }


    /**
     * 将上一个题的方法经过个改造
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private TreeNode sortedArrayToBSTHelp(List<Integer> nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums.get(start));
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left  = sortedArrayToBSTHelp(nums, start, mid - 1);
        root.right = sortedArrayToBSTHelp(nums, mid + 1, end);
        return root;
    }

    /**
     * 利用快慢指针找中点
     * @param head
     * @return
     */
    public TreeNode sortedListToBST2(ListNode head) {
        if (head == null) {
            return null;
        }
        return sortedListToBSTHelp(head, null);
    }

    private TreeNode sortedListToBSTHelp(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }

        ListNode fast = start;
        ListNode slow = start;
        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBSTHelp(start, slow);
        root.right = sortedListToBSTHelp(slow.next, end);
        return root;
    }

}
