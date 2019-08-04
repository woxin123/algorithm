package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	l1 := head
	for i := 0; i < n; i++ {
		l1 = l1.Next
	}
	l2 := head
	if l1 == nil {
		return head.Next
	}
	for l1.Next != nil {
		l1 = l1.Next
		l2 = l2.Next
	}
	if l2.Next != nil {
		l2.Next = l2.Next.Next
	} else {
		l2.Next = nil
	}

	return head
}
