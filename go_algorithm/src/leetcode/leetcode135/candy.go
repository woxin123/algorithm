package main

import "fmt"

func candy(ratings []int) int {
	sum := 0
	left2right := make([]int, len(ratings))
	right2left := make([]int, len(ratings))
	for i := 0; i < len(ratings); i++ {
		left2right[i] = 1
		right2left[i] = 1
	}
	for i := 1; i < len(ratings); i++ {
		if ratings[i] > ratings[i-1] {
			left2right[i] = left2right[i-1] + 1
		}
	}
	for i := len(ratings) - 2; i >= 0; i-- {
		if ratings[i] > ratings[i+1] {
			right2left[i] = right2left[i+1] + 1
		}
	}

	for i := 0; i < len(ratings); i++ {
		sum += max(left2right[i], right2left[i])
	}
	return sum
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	ratings := []int{1, 0, 2}
	fmt.Println(candy(ratings))
}
