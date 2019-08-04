package main

import "fmt"

func nextPermutation(nums []int) {
	if len(nums) == 0 {
		return
	}
	i := len(nums) - 1
	for i > 0 && nums[i-1] >= nums[i] {
		i--
	}
	if i > 0 {
		j := len(nums) - 1
		for j > i-1 && nums[j] <= nums[i-1] {
			j--
		}
		nums[i-1], nums[j] = nums[j], nums[i-1]
	}
	j := len(nums) - 1
	for i < j {
		nums[i], nums[j] = nums[j], nums[i]
		i++
		j--
	}
}

func main() {
	nums := []int{5, 1, 1}
	nextPermutation(nums)
	fmt.Println(nums)
}
