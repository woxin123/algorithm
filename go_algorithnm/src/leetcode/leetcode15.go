package main

import (
	"fmt"
	"sort"
)

func threeSum(nums []int) [][]int {
	if len(nums) < 3 {
		res := make([][]int, 1)
		res = append(res, nums)
		res[0] = nums
		return res
	}
	sort.Ints(nums)
	res := make([][]int, 0)
	var resever, s, e int
	for i := 0; i < len(nums)-2; i++ {
		resever = -nums[i]
		s = i + 1
		e = len(nums) - 1
		for s < e {
			if nums[s]+nums[e] == resever {
				arr := [...]int{nums[i], nums[s], nums[e]}
				res = append(res, arr[0:])
				s++
				for s < e && nums[s-1] == nums[s] {
					s++
				}
				e--
			} else if nums[s]+nums[e] < resever {
				s++
				for s < e && nums[s-1] == nums[s] {
					s++
				}
			} else {
				e--
			}
		}
		for i+1 < len(nums)-2 && nums[i] == nums[i+1] {
			i++
		}
	}
	return res
}

func main() {
	arr := make([]int, 1)
	arr = append(arr, -4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6)
	fmt.Println(threeSum(arr))
}
