package main

import (
	"fmt"
)

func jump(nums []int) int {
	if (len(nums) == 1) {
		return 0;
	}
	jumpMin := 1
	preMaxMaxIndex := nums[0]
	currentMaxIndex := nums[0]

	for i := 1; i < len(nums); i++ {
		if currentMaxIndex < i {
			currentMaxIndex = preMaxMaxIndex
			jumpMin++
		}
		if preMaxMaxIndex < nums[i]+i {
			preMaxMaxIndex = nums[i] + i
		}
	}
	return jumpMin
}

func main() {
	nums := []int {2, 1}
	fmt.Println(jump(nums))
}