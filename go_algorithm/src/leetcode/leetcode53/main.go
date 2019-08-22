package main

import "fmt"

func maxSubArray(nums []int) int {
	max := nums[0]
	temp := 0
	for i := 0; i < len(nums); i++ {
		if temp > 0 {
			temp += nums[i]
		} else {
			temp = nums[i];
		}
		if temp > max {
			max = temp
		}
	}
	return max
}

func main() {
	nums := []int{-2, 1, -3, 4, -1, 2, 1, -5, 4}
	max := maxSubArray(nums)
	fmt.Println(max)
}
