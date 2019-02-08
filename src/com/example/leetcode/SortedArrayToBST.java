package com.example.leetcode;

/**
 * @author mengchen
 * @time 19-2-8 下午2:57
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        return sortedArrayToBSTHelp(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTHelp(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left  = sortedArrayToBSTHelp(nums, start, mid - 1);
        root.right = sortedArrayToBSTHelp(nums, mid + 1, end);
        return root;
    }
}
