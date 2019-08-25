package main

import (
	"fmt"
	"sort"
)

func findContentChildren(g []int, s []int) int {
	sort.Ints(g)
	sort.Ints(s)
	index := 0
	count := 0
	for i := 0; i < len(g) && index < len(s); {
		if g[i] <= s[index] {
			i++
			index++
			count++
		} else {
			index++
		}
	}
	return count
}

func main() {
	fmt.Println(findContentChildren([]int{10, 9, 8, 7}, []int{5, 6, 7, 8}))
}
