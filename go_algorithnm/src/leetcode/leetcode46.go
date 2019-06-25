package main

import "fmt"

/**
leetcode 46 全排列
回溯法
 */

func permute(nums []int) [][]int {
	if len(nums) == 0 {
		return nil
	}
	res := make([][]int, 0, len(nums))
	res = backTrace(res, nums, 0)
	return res
}

func backTrace(res [][]int, nums []int, first int) [][]int {
	if len(nums) == first {
		temp := make([]int, len(nums))
		copy(temp, nums)
		res = append(res, temp)
		return res
	}
	for i := first; i < len(nums); i++ {
		nums[first], nums[i] = nums[i], nums[first]
		res = backTrace(res, nums, first + 1)
		nums[first], nums[i] = nums[i], nums[first]
	}
	return res
}

func main() {
	res := permute([]int{1, 2, 3})
	fmt.Println(res)
}
