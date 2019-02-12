package com.example.leetcode;

/**
 * @author mengchen
 * @time 19-2-12 上午11:58
 */
public class Connect {
    /**
     * 填充同一层的兄弟节点
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode cur = root;
        while (true) {
            if (cur.left == null) {
                return;
            }
            TreeLinkNode next = cur.left;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                } else {
                    break;
                }
                cur = cur.next;
            }
            cur = next;
        }
    }

    /**
     * 填充同一层的兄弟节点 II
     *    1
     *   / \
     *  2   3
     *     / \
     *     6  7
     *
     * @param root
     */
    public void connectII(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode cur = root;
        TreeLinkNode next = null;
        TreeLinkNode nextCur = null;
        while (true) {

            while (cur != null) {
                if (next == null) {
                    next = cur.left == null ? cur.right : cur.left;
                    nextCur = next;
                    if (next == cur.left) {
                        if (cur.right != null) {
                            next.next = cur.right;
                            next = next.next;
                        }
                    }
                } else {
                    if (cur.left != null) {
                        next.next = cur.left;
                        next = next.next;
                    }
                    if (cur.right != null) {
                        next.next = cur.right;
                        next = next.next;
                    }
                }
                cur = cur.next;
            }
            if (next == null) {
                return;
            }
            next = null;
            cur = nextCur;
        }

    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(0);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(4);
        root.left.left = new TreeLinkNode(1);
        root.right.left = new TreeLinkNode(3);
        root.right.right = new TreeLinkNode(-1);
        root.left.left.left = new TreeLinkNode(5);
        root.left.left.right = new TreeLinkNode(1);
        root.right.left.right = new TreeLinkNode(6);
        root.right.right.right = new TreeLinkNode(8);

        Connect connect = new Connect();
        connect.connectII(root);
        System.out.println(root.val);
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}
