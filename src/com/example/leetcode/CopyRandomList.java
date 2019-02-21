package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表
 * @author mengchen
 * @time 19-2-21 下午3:32
 */
public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode newHead = new RandomListNode(0);
        RandomListNode p = newHead;
        while (head != null){
            if (!map.containsKey(head)) {
                p.next = new RandomListNode(head.label);
                map.put(head, p.next);
            } else {
                p.next = map.get(head);
            }
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    p.next.random = new RandomListNode(head.random.label);
                    map.put(head.random, p.next.random);
                } else {
                    p.next.random = map.get(head.random);
                }
            }
            p = p.next;
            head = head.next;
        }
        return newHead.next;
    }


    public static void main(String[] args) {
        RandomListNode m = new RandomListNode(-1);
        RandomListNode n = new RandomListNode(1);
        m.next= n;
        m.random = n;
        n.random = m;
        new CopyRandomList().copyRandomList(m);
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}
