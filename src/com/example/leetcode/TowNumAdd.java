package com.example.leetcode;

import com.example.leetcode.util.ListNode;

import java.util.List;

/**
 * @author mengchen
 * @time 18-10-23 下午3:12
 */
public class TowNumAdd {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);
        ListNode l1 = listNode1;
        l1.next = new ListNode(8);
//        l1.next.next = new ListNode(3);
        ListNode listNode2 = new ListNode(1);
        ListNode l2 = listNode2;
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        TowNumAdd t = new TowNumAdd();
        ListNode listNode = t.addTwoNumbers(listNode1, listNode2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        int other = 0;
        ListNode pre = null;
        boolean flag = false;
        while (l1 != null && l2 != null) {
            int temp = l1.val + l2.val + other;
            other = temp / 10;
            ListNode tempNode = new ListNode(temp % 10);
            if (flag == false) {
                pre = tempNode;
                result = pre;
                flag = true;
            } else {
                pre.next = tempNode;
                pre = pre.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int temp = l1.val + other;
            if (other != 0) {
                other = temp / 10;
            }
            pre.next = new ListNode(temp % 10);
            pre = pre.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int temp = l2.val + other;
            if (other != 0) {
                other = temp / 10;
            }
            pre.next = new ListNode(temp % 10);
            pre = pre.next;
            l2 = l2.next;
        }
        if (other != 0) {
            pre.next = new ListNode(other);
        }
        return result;
    }*/

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}
