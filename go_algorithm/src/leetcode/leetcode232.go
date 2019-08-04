package main

import (
	"container/list"
	"fmt"
)

type MyQueue struct {
	s1 list.List
	s2 list.List
	front int
}


/** Initialize your data structure here. */
func Constructor() MyQueue {
	return MyQueue{}
}


/** Push element x to the back of queue. */
func (this *MyQueue) Push(x int)  {
	if this.s1.Len() == 0 {
		this.front = x
	}
	this.s1.PushFront(x)
}


/** Removes the element from in front of queue and returns that element. */
func (this *MyQueue) Pop() int {
	if this.s2.Len() == 0 {
		for e := this.s1.Front(); e != nil; e = e.Next() {
			this.s2.PushFront(e.Value)
		}
		this.s1.Init()
	}
	res := this.s2.Front().Value
	this.s2.Remove(this.s2.Front())
	return res.(int)
}


/** Get the front element. */
func (this *MyQueue) Peek() int {
	if this.s2.Len() != 0 {
		return this.s2.Front().Value.(int)
	}
	return this.front
}


/** Returns whether the queue is empty. */
func (this *MyQueue) Empty() bool {
	return this.s1.Len() == 0 && this.s2.Len() == 0
}

func main() {
	q := Constructor()
	q.Push(1)
	q.Push(2)
	fmt.Println(q.Pop())
	fmt.Println(q.Peek())

}

