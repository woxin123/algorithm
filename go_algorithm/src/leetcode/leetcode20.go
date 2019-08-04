package main

import (
	"container/list"
	"fmt"
)



func isValid(s string) bool {
	kMap := map[int32]int32 {
		')': '(', ']': '[', '}': '{',
	}
	list := list.New()
	for _, v := range s {
		if list.Len() != 0 && kMap[v] == list.Back().Value.(int32) {
			list.Remove(list.Back())
		} else {
			list.PushBack(v)
		}
	}
	return list.Len() == 0
}

func main() {
	fmt.Println(isValid("[{([()])}]"))
}
