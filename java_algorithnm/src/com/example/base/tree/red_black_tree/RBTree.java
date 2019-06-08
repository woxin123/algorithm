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
     * p                       p
     * /                       /
     * x                       y
     * / \                     / \
     * lx  y      ----->       x  ry
     * / \                 / \
     * ly ry               lx ly
     * 左旋做了三件事情
     * 1. 将y的左节点赋给x的右子节点，并将x左子节点赋给父节点（y的右子节点非空时）
     * 2. 将x的父节点p(非空时)赋给父节点，同事更新p的子节点为y（左或者右）
     * 3. 将y的左子节点设为x，将x的父节点设置为y
     *
     * @param x
     */
    private void leftRotate(RBNode<T> x) {
        // 将y的左子节点赋给x的右子节点，并将x赋给y的左子节点(y左子节点非空时)
        RBNode<T> y = x.right;
        x.right = y.left;
        // 如果y.left不为空，这里就要转换父子关系
        if (y.left != null) {
            y.left.parent = x;
        }
        // 因为y节点要成为x节点的父节点，这里x的父节点要变成y的父节点
        y.parent = x.parent;
        // 这里证明x是root根节点
        if (x.parent == null) {
            root = y;
        } else {
            // 如果x是左节点
            if (x.parent.left == x) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }
        // 将y的左节点设置为x
        y.left = x;
        // 把x的父节点设置为y
        x.parent = y;
    }

    /**
     *-----------对红黑树节点y进行右旋操作---------
     * 左旋示意图：对节点y进行右旋
     *        p                   p
     *       /                   /
     *      y                   x
     *     / \                 / \
     *    x  ry   ----->      lx  y
     *   / \                     / \
     * lx  rx                   rx ry
     * 1. 把x的右节点赋给y的左节点
     * 2. 把y的父节点赋给x
     * @param y
     */
    private void rightRotate(RBNode<T> y) {
        RBNode<T> x = y.left;
        y.left = x.right;
        // x.right不为空，转换父子关系
        if (x.right != null) {
            x.right.parent = y.parent;
        }
        x.parent = y.parent;
        // 如果y的父节点为null，那么y就是根节点，所以
        if (y.parent == null) {
            // 将root节点指向x
            this.root = x;
        }
        // 确定x的左右子节点
        if (y.parent.left == y) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }

        // x的右节点指向y
        x.right = y;
        // y的parent指向x
        y.parent = x;
    }

    /*********************** 向红黑树中插入节点 **********************/
    public void insert(T key) {
        RBNode<T> node = new RBNode<T>(key, RED, null, null, null);
        if(node != null) {
            insert(node);
        }
    }

    private void insert(RBNode<T> node) {
        // 表示最后node的父节点
        RBNode<T> current = null;
        // 用来向下搜索的节点
        RBNode<T> x = this.root;

        // 找到插入的位置
        while (x != null) {
            current = x;
            int cmp = node.key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        // 找到了插入的位置，将当前节点的current作为node的父节点
        node.parent = current;
        // 判断node插入左子节点还是右子节点
        if (current != null) {
            int cmp = node.key.compareTo(current.key);
            if (cmp < 0) {
                current.left = node;
            } else {
                current.right = node;
            }
        } else {
            this.root = node;
        }

        // 重新修复成一颗红黑树
        insertFixUp(node);
    }

    private void insertFixUp(RBNode<T> node) {
        RBNode<T> parent, gparent; //定义父节点和祖父节点

        //需要修整的条件：父节点存在，且父节点的颜色是红色
        while(((parent = parentOf(node)) != null) && isRed(parent)) {
            gparent = parentOf(parent);//获得祖父节点

            //若父节点是祖父节点的左子节点，下面else与其相反
            if(parent == gparent.left) {
                RBNode<T> uncle = gparent.right; //获得叔叔节点

                //case1: 叔叔节点也是红色
                if(uncle != null && isRed(uncle)) {
                    setBlack(parent); //把父节点和叔叔节点涂黑
                    setBlack(uncle);
                    setRed(gparent); //把祖父节点涂红
                    node = gparent; //将位置放到祖父节点处
                    continue; //继续while，重新判断
                }

                //case2: 叔叔节点是黑色，且当前节点是右子节点
                if(node == parent.right) {
                    leftRotate(parent); //从父节点处左旋
                    RBNode<T> tmp = parent; //然后将父节点和自己调换一下，为下面右旋做准备
                    parent = node;
                    node = tmp;
                }

                //case3: 叔叔节点是黑色，且当前节点是左子节点
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
            } else { //若父节点是祖父节点的右子节点,与上面的完全相反，本质一样的
                RBNode<T> uncle = gparent.left;

                //case1: 叔叔节点也是红色
                if(uncle != null & isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }

                //case2: 叔叔节点是黑色的，且当前节点是左子节点
                if(node == parent.left) {
                    rightRotate(parent);
                    RBNode<T> tmp = parent;
                    parent = node;
                    node = tmp;
                }

                //case3: 叔叔节点是黑色的，且当前节点是右子节点
                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }

        //将根节点设置为黑色
        setBlack(this.root);
    }

    public static void main(String[] args) {
        RBTree<Integer> tree = new RBTree<>();
        tree.insert(12);
        tree.insert(1);
        tree.insert(9);
        System.out.println(tree.root.key);
    }
}