package com.example.interview;

import com.example.leetcode.util.ListNode;

import java.math.BigInteger;

/**
 * @author mengchen
 * @time 19-4-3 下午8:02
 */
public class ListAdd {

    public ListNode listAdd(ListNode node1, ListNode node2) {
        StringBuilder sb1 = new StringBuilder();
        while (node1 != null) {
            sb1.append(node1.val);
            node1 = node1.next;
        }

        StringBuilder sb2 = new StringBuilder();
        while (node2 != null) {
            sb2.append(node2.val);
            node2 = node2.next;
        }

        BigInteger b1 = new BigInteger(sb1.toString());
        BigInteger b2 = new BigInteger(sb2.toString());
        BigInteger res = b1.add(b2);
        String s = res.toString();
        ListNode resNode = null;
        ListNode p = null;
        for (char ch : s.toCharArray()) {
            if (resNode == null) {
                resNode = new ListNode(ch - '0');
                p = resNode;
            } else {
                p.next = new ListNode(ch - '0');
                p = p.next;
            }
        }
        return resNode;
    }

    public static void main(String[] args) {
        ListAdd listAdd = new ListAdd();
        System.out.println(listAdd.listAdd(ListNode.listFromIntegers(new int[]{1, 2, 3, 4, 5, 6}),
                ListNode.listFromIntegers(new int[]{6, 5, 4, 3, 2})));
    }

}
