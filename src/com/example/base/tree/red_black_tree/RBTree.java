package com.example.base.tree.red_black_tree;

/**
 * @author mengchen
 * @time 18-11-8 下午12:14
 */
public class RBTree<T extends Comparable<T>> {
    /**
     * 根节点
     */
    private RBNode<T> root;

    /**
     * 定义红黑数的标志
     */
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public class RBNode<T extends Comparable<T>> {
        /**
         * 节点的颜色
         */
        boolean color;
        /**
         * 关键字（键值）
         */
        T key;

        /**
         * 左子节点
         * 右子节点
         * 父节点
         */
        RBNode<T> left;
        RBNode<T> right;
        RBNode<T> parent;

        public RBNode(T key, boolean color, RBNode<T> parent, RBNode<T> left, RBNode<T> right) {
            this.color = color;
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public T getKey() {
            return this.key;
        }

        @Override
        public String toString() {
            return key + (this.color == RED ? "R" : "B");
        }

    }

    public RBTree() {
        root = null;
    }

    public RBNode<T> parentOf(RBNode<T> node) {
        return node != null ? node.parent : null;
    }

    public void setParent(RBNode<T> node, RBNode<T> parent) {
        if (node != null) {
            node.parent = parent;
        }
    }

    public boolean isRed(RBNode<T> node) {
        return node != null && node.color == RED;
    }

    public boolean isBlack(RBNode<T> node) {
        return !isRed(node);
    }

    public void setRed(RBNode<T> node) {
        if (node != null) {
            node.color = RED;
        }
    }

    public void setBlack(RBNode<T> node) {
        if (node != null) {
            node.color = BLACK;
        }
    }

    public void setColor(RBNode<T> node, boolean color) {
        if (node != null) {
            node.color = color;
        }
    }

    /**
     * 对红黑树节点x进行左旋操作
     * 左旋示意图：对节点x进行左旋
     *     p                       p
     *    /                       /
     *   x                       y
     *  / \                     / \
     * lx  y      ----->       x  ry
     *    / \                 / \
     *   ly ry               lx ly
     * 左旋做了三件事情
     * 1. 将y的左节点赋给x的右子节点，并将x左子节点赋给父节点（y的右子节点非空时）
     * 2. 将x的父节点p(非空时)赋给父节点，同事更新p的子节点为y（左或者右）
     * 3. 将y的左子节点设为x，将x的父节点设置为y
     * @param x
     */
    private void leafRotate(RBNode<T> x) {
        // 将y的左子节点赋给x的右子节点，并将x赋给y的左子节点(y左子节点非空时)
        RBNode<T> y = x.right;
        x.right = y.left;

        if (y.left != null) {
            y.left.parent = x;
        }
    }

}
