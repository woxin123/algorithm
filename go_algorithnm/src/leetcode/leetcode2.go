package main

/*
 * 链表节点
 */
type ListNode struct {
	Val int
	Next *ListNode
}
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return nil
	}
	res := &ListNode{0, nil}
	head := res
	var x int
	for l1 != nil || l2 != nil {
		var a, b int
		if l1 != nil {
			a = l1.Val	
			l1 = l1.Next		
		} else {
			a = 0
		}
		if l2 != nil {
			b = l2.Val
			l2 = l2.Next
		} else {
			b = 0
		}
		c := a + b + x
		x = c / 10
		res.Next = &ListNode{c % 10, nil}
		res = res.Next
	}
	
	if x != 0 {
		res.Next = &ListNode{x, nil}
	}
	return head.Next
}