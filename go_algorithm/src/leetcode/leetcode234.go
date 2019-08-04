package main

type ListNode struct {
	Val int
	Next *ListNode
}

func isPalindrome(head *ListNode) bool {
	if head == nil || head.Next == nil {
		return true
	}

	slow, fast := head, head.Next
	var cur, pre *ListNode
	for fast != nil && fast.Next != nil {
		pre = slow
		slow, fast = slow.Next, fast.Next.Next
		pre.Next = cur
		cur = pre
	}
	p1 := slow.Next
	slow.Next = pre
	p2 := slow
	if fast == nil {
		p2 = slow.Next
	}
	for p2 != nil {
		if p1.Val != p2.Val {
			return false
		}
		p1, p2 = p1.Next, p2.Next
	}
	return true
}

func main() {
	head := &ListNode{
		Val: 1,
		Next: &ListNode{2, nil},
	}
	isPalindrome(head)
}
