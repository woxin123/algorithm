package com.example.leetcode;


import com.example.leetcode.util.TreeNode;

import java.util.*;

/**
 * @author mengchen
 * @time 18-11-29 下午3:29
 */
public class TreeSolution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrderTraversal(root, list);
        return list;
    }

    private void preOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        preOrderTraversal(root.left, list);
        preOrderTraversal(root.right, list);
    }

    public List<Integer> preOrderTraversalWithStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    private void inorderTraversal(TreeNode root, List list) {
        if (root == null)
            return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    public List<Integer> inorderTraversalWithStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }
        }
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversal(root, list);
        return list;
    }

    public void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);
    }


    public List<Integer> postorderTraversalWithStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur;
        TreeNode pre = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if ((cur.left == null && cur.right == null) ||
                    (pre != null && (pre == cur.left || pre == cur.right))) {
                list.add(cur.val);
                stack.pop();
                pre = cur;
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        return list;
    }

    /**
     * 迭代的实现
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Queue<TreeNode> queue2 = new LinkedList<>();
        while (!queue.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode p = queue.poll();
                l.add(p.val);
                if (p.left != null) {
                    queue2.offer(p.left);
                }
                if (p.right != null) {
                    queue2.offer(p.right);
                }
            }
            Queue temp = queue;
            queue = queue2;
            queue2 = temp;
            list.add(l);
        }
//        Collections.reverse(list);
        return list;
    }

    public List<List<Integer>> levelOrderWithRecursive(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        levelOrderRecursive(lists, 0, root);
        return lists;
    }

    private void levelOrderRecursive(List<List<Integer>> lists, int level, TreeNode root) {
        if (root == null) {
            return;
        }
        if (lists.size() == level) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            lists.add(list);
        } else {
            lists.get(level).add(root.val);
        }
        levelOrderRecursive(lists, level + 1, root.left);
        levelOrderRecursive(lists, level + 1, root.right);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTreeWithRecursive(0, nums.length - 1, nums);
    }

    public TreeNode constructMaximumBinaryTreeWithRecursive(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructMaximumBinaryTreeWithRecursive(start, maxIndex - 1, nums);
        root.right = constructMaximumBinaryTreeWithRecursive(maxIndex + 1, end, nums);
        return root;
    }

    /**
     * 二叉树剪枝
     *
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }

    /**
     * 合并二叉树
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode root;
        if (t1 != null && t2 != null) {
            root = new TreeNode(t1.val + t2.val);
        } else if (t1 == null) {
            root = new TreeNode(t2.val);
        } else {
            root = new TreeNode(t1.val);
        }
        root.left = mergeTrees((t1 == null) ? null : t1.left, (t2 == null) ? null : t2.left);
        root.right = mergeTrees((t1 == null) ? null : t1.right, (t2 == null) ? null : t2.right);
        return root;
    }

    /**
     * 从中序与后序遍历序列构造二叉树
     *
     * @param inorder
     * @param postorder
     * @return
     */
    private int countIP = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder, boolean flag) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        countIP = postorder.length - 1;
        return buildTreeHelp(inorder, postorder, 0, postorder.length - 1);
    }


    private TreeNode buildTreeHelp(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[countIP]);
        if (start == end) {
            countIP--;
            return node;
        }
        int a = 0;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == postorder[countIP]) {
                a = i;
                countIP--;
                break;
            }
        }
        node.right = buildTreeHelp(inorder, postorder, a + 1, end);
        node.left = buildTreeHelp(inorder, postorder, start, a - 1);
        return node;
    }


    /**
     * 从前序与中序遍历序列构造二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeRecursive(0, inorder.length - 1, preorder, inorder);
    }

    private int count = 0;

    public TreeNode buildTreeRecursive(int start, int end, int[] preorder, int[] inorder) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[count]);
        int index = -1;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == preorder[count]) {
                index = i;
                count++;
                break;
            }
        }
        if (index == -1) {
            return null;
        }
        root.left = buildTreeRecursive(start, index - 1, preorder, inorder);
        root.right = buildTreeRecursive(index + 1, end, preorder, inorder);

        return root;
    }

    public static void main(String[] args) {
        TreeSolution treeSolution = new TreeSolution();
        TreeNode treeNode = treeSolution.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}, false);
        System.out.println(treeSolution.levelOrder(treeNode));
    }
}
