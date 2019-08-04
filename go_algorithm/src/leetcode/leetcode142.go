package main

func detectCycle(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}
	fast, slow := head, head
	for fast != nil && fast.Next != nil {
		fast, slow = fast.Next.Next, slow.Next
		if fast == slow {
			if fast != nil {
				fast = head
				for fast != slow {
					fast, slow = fast.Next, slow.Next
				}
			}
			return fast
		}
	}
	return nil
}

func main() {

}
