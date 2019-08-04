package main

import "fmt"

/**
leetcode 46 全排列II
回溯法
 */

func permuteUnique(nums []int) [][]int {
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
	for i := first; i < len(nums); {
		j := i
		for j < len(nums) && nums[j] == nums[i] {
			j++
		}
		nums[first], nums[i] = nums[i], nums[first]
		res = backTrace(res, nums, first + 1)
		nums[first], nums[i] = nums[i], nums[first]
		i = j
	}
	return res
}

func main() {
	res := permuteUnique([]int{1, 1, 1, 0})
	fmt.Println(res)
}
