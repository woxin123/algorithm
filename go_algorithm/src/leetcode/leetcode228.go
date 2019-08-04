package main

import (
	"fmt"
	"strconv"
)

func summaryRanges(nums []int) []string {
	if len(nums) == 0 {
		return nil
	}
	s, l := nums[0], nums[0]
	res := make([]string, 0)
	for i := 1; i < len(nums); i++ {
		if (nums[i] - l) == 1 {
			l = nums[i]
		} else {
			if s != l {
				res = append(res, string(strconv.Itoa(s))+"->"+string(strconv.Itoa(l)))
			} else {
				res = append(res, strconv.Itoa(s))
			}
			s = nums[i]
			l = s
		}
	}
	if l == s {
		fmt.Println(s)
		res = append(res, strconv.Itoa(s))
	} else {
		res = append(res, strconv.Itoa(s)+"->"+strconv.Itoa(l))
	}
	return res
}

func main() {
	res := summaryRanges([]int{1, 2, 3, 4, 5, 7, 8, 9, 11, 13, 14, 15, 16, 17, 20, 25})
	fmt.Println(res)
}
