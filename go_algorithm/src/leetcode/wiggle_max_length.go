package main

import (
	"fmt"
)

const (
	BEGIN int = iota
	UP
	DOWN
)

func wiggleMaxLength(nums []int) int {
	if len(nums) < 2 {
		return len(nums)
	}
	state := BEGIN
	maxLength := 1
	for i := 1; i < len(nums); i++ {
		switch state {
		case BEGIN:
			if nums[i-1] < nums[i] {
				state = UP
				maxLength += 1
			} else if nums[i-1] > nums[i] {
				state = DOWN
				maxLength += 1
			}
		case UP:
			if nums[i-1] > nums[i] {
				state = DOWN
				maxLength += 1
			}
		case DOWN:
			if nums[i - 1] < nums[i] {
				state = UP
				maxLength += 1
			}
		}
	}
	return maxLength
}

func main() {
	maxLength := wiggleMaxLength([]int{1, 17, 5, 10, 13, 15, 10, 5, 16, 8})
	fmt.Println(maxLength)
}
