package main

import (
	"container/list"
)

type LRUCache struct {
	cache list.List
	data map[int] *list.Element
	size  int
}

type pair struct {
	Key int
	Val int
}

func Constructor(capacity int) LRUCache {
	return LRUCache{
		data: make(map[int]*list.Element),
		size: capacity,
	}
}

func (this *LRUCache) Get(key int) int {
	if this.cache.Len() > 0 {
		e := this.data[key]
		if e == nil {
			return -1
		}
		if e != this.cache.Front() {
			this.cache.MoveToFront(e)
		}
		return e.Value.(*pair).Val
	}
	return -1
}

func (this *LRUCache) Put(key int, value int) {
	if this.cache.Len() > 0 {
		e := this.data[key]
		if e != nil {
			e.Value.(*pair).Val = value
			if e != this.cache.Front() {
				this.cache.MoveToFront(e)
			}
			return
		}
	}
	if this.cache.Len() >= this.size {
		delete(this.data, this.cache.Back().Value.(*pair).Key)
		this.cache.Remove(this.cache.Back())

	}
	this.data[key] = this.cache.PushFront(&pair{key, value})
}


func main() {
	lrucache := Constructor(2)
	lrucache.Get(2)
	lrucache.Put(2, 1)
	lrucache.Put(1, 4)
	lrucache.Get(1)
}
