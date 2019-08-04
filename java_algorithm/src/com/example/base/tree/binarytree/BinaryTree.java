package com.example.base.tree.binarytree;

import com.example.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mengchen
 * @time 18-11-29 下午2:56
 */
public class BinaryTree<T> {

    private BinaryNode<T> root;

    private class BinaryNode<T> {
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;

        public BinaryNode(T element) {
            this.element = element;
        }

        public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }


    private void init(T[] array) {
        BinaryTree<T> tree = this;
        BinaryNode a = new BinaryNode<>(array[0]);
        tree.root = a;
        root.left = new BinaryNode<>(array[1]);
        root.right = new BinaryNode<>(array[2]);
        BinaryNode<T> left = root.left;
        left.left = new BinaryNode<>(array[3]);
        left.right = new BinaryNode<>(array[4]);
        BinaryNode<T> right = root.right;
        right.left = new BinaryNode<>(array[5]);
        right.right = new BinaryNode<>(array[6]);
        left.left.left = new BinaryNode<>(array[7]);
        left.right.right = new BinaryNode<>(array[8]);
        right.left.left = new BinaryNode<>(array[9]);
        right.left.right = new BinaryNode<>(array[10]);
    }

    public List<T> preOrderTraversal() {
        List<T> list = new ArrayList<>();
        preOrderTraversal(root, list);
        return list;
    }

    private void preOrderTraversal(BinaryNode<T> root, List<T> list) {
        if (root == null)
            return;
        list.add(root.element);
        preOrderTraversal(root.left, list);
        preOrderTraversal(root.right, list);
    }

    public List<T> preOrderTraversalWithStack() {
        List<T> list = new ArrayList<>();
        LinkedList<BinaryNode<T>> stack = new LinkedList<>();
        BinaryNode<T> p = this.root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                list.add(p.element);
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.right;
            }
        }
        return list;
    }

    public List<T> inorderTraversal() {
        List<T> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    public void inorderTraversal(BinaryNode<T> root, List<T> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.element);
        inorderTraversal(root.right, list);
    }

    public List<T> inorderTraversalWithStack() {
        List<T> list = new ArrayList<>();
        LinkedList<BinaryNode<T>> stack = new LinkedList<>();
        BinaryNode<T> p = this.root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                list.add(p.element);
                p = p.right;
            }
        }
        return list;
    }

    public List<T> postorderTraversal() {
        List<T> list = new ArrayList<>();
        postorderTraversal(this.root, list);
        return list;
    }

    public void postorderTraversal(BinaryNode<T> root, List<T> list) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.element);
    }

    public List<T> postorderTraversalWithStack() {
        List<T> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<BinaryNode<T>> stack = new LinkedList<>();
        BinaryNode<T> cur;
        BinaryNode<T> pre = null;
        stack.push(this.root);
        while (!stack.isEmpty()) {
            // 取当前栈顶
            cur = stack.peek();
            // 判断是否出栈
            if ((cur.left == null && cur.right == null) ||
                    (pre != null && (pre == cur.left || pre == cur.right))) {
                // 访问
                list.add(cur.element);
                // 出栈
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

    public List<List<T>> levelOrder() {
        Queue<BinaryNode<T>> queue = new LinkedList<>();
        queue.offer(this.root);
        Queue<BinaryNode<T>> queue2 = new LinkedList<>();
        List<List<T>> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<T> l = new ArrayList<>();
            while (!queue.isEmpty()) {
                BinaryNode<T> p = queue.poll();
                l.add(p.element);
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
        return list;
    }

    public static void main(String[] args) {
        BinaryTree<Character> tree = new BinaryTree<>();
        tree.init(new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'});
        System.out.println(tree.preOrderTraversal());
        System.out.println(tree.preOrderTraversalWithStack());
        System.out.println(tree.inorderTraversal());
        System.out.println(tree.inorderTraversalWithStack());
        System.out.println(tree.postorderTraversal());
        System.out.println(tree.postorderTraversalWithStack());
        System.out.println(tree.levelOrder());
    }
}
