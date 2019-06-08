package com.example.剑指offer;

import com.example.leetcode.util.ListNode;

import java.util.Scanner;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class AddTwoList {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode list3 = null;
        ListNode per1 = list1;
        ListNode per2 = list2;
        ListNode per3 = list3;
        while (per1 != null && per2 != null) {
            if (per1.val < per2.val) {
                if (list3 == null) {
                    list3 = per1;
                } else
                    per3.next = per1;
                per3 = per1;
                per1 = per1.next;
            } else {
                if (list3 == null) {
                    list3 = per2;
                } else
                    per3.next = per2;
                per3 = per2;
                per2 = per2.next;
            }
        }
        while (per1 != null) {
//            if (list3 == null) {
//                list3 = per1;
//            per3 = list3;
//            } else
            per3.next = per1;
            per3 = per1;
            per1 = per1.next;
        }
        while (per2 != null) {
//            if (list3 == null) {
//                list3 = per2;
//            per3 = list3;
//            } else
            per3.next = per2;
            per3 = per2;
            per2 = per2.next;
        }
        return list3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode list1 = null;
        ListNode tail1 = null;
        ListNode list2 = null;
        ListNode tail2 = null;
        while (true) {
            int a = sc.nextInt();
            if (a == 0)
                break;
            ListNode per1 = new ListNode(a);
            if (list1 == null) {
                list1 = per1;
            } else {
                tail1.next = per1;
            }
            tail1 = per1;
        }
        while (true) {
            int b = sc.nextInt();
            if (b == 0)
                break;
            ListNode per2 = new ListNode(b);
            if (list2 == null) {
                list2 = per2;
            } else {
                tail2.next = per2;
            }
            tail2 = per2;
        }
        ListNode p1 = list1;
        while (p1 != null) {
            System.out.print(p1.val + " ");
            p1 = p1.next;
        }
        System.out.println();
        ListNode p2 = list2;
        while (p2 != null) {
            System.out.print(p2.val + " ");
            p2 = p2.next;
        }
        System.out.println();
        AddTwoList addTwoList = new AddTwoList();
        ListNode list3 = addTwoList.Merge(list1, list2);
        while (list3 != null) {
            System.out.print(list3.val + " ");
            list3 = list3.next;
        }
    }

}
