package main

import (
	"fmt"
)

func canJump(nums []int) bool {
	jump := 0
	maxIndex := nums[0]
	for jump <= maxIndex && jump < len(nums) {
		if maxIndex < nums[jump] + jump {
			maxIndex = nums[jump] + jump
		}
		jump++
	}
	if jump == len(nums) {
		return true
	}
	return false
}

func main() {
	nums := []int {2, 3, 1, 1, 4}
	fmt.Println(canJump(nums))
}