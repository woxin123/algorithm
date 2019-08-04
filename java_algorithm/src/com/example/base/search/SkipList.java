package com.example.base.search;

import java.util.Random;

/**
 * @author mengchen
 * @time 18-12-12 下午4:48
 */
public class SkipList {
    private static final int MAX_LEVEL = 16;

    private int levelCount = 1;

    // 带头结点的链表
    private Node head = new Node();

    private final Random random = new Random();

    public Node find(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    public void insert(int value) {
        // 获取一个随机数
        int level = randomLevel();
        // 创建一个新的节点
        Node newNode = new Node();
        // 赋值
        newNode.data = value;
        // 赋层数的值
        newNode.maxLevel = level;
        // 创建一个列数组
        Node[] update = new Node[level];
        // 赋值head
        for (int i = 0; i < level; i++) {
            update[i] = head;
        }

        Node p = head;
        // 查找value应该插入的位置
        for (int i = level - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        // 每一个Node中都存储了大于Node本身value值引用
        for (int i = 0; i < level; ++i) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }

        if (levelCount < level) {
            levelCount = level;
        }
    }

    private class Node {
        private int data = -1;
        private Node[] forwards = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; level: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }

    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }
        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }
    }

    private int randomLevel() {
        int level = 1;
        for (int i = 0; i < MAX_LEVEL; i++) {
            if (random.nextInt() % 2 == 1) {
                level++;
            }
        }

        return level;
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        for (int i = 0; i < 100; i++) {
            if (i == 55) {
                continue;
            }
            skipList.insert(i);
        }
        skipList.insert(55);
        System.out.println(skipList.find(33));
        skipList.delete(33);
        System.out.println(skipList.find(33));
    }
}
