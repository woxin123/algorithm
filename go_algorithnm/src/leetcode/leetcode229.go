package main

import (
	"fmt"
)

func majorityElement(nums []int) []int {
	if len(nums) == 0 {
		return nil
	}
	fmt.Println(nums)
	l := len(nums)
	maj1, maj2, c1, c2 := 0, 0, 0, 0
	for _, v := range nums {
		if c1 == 0 && maj2 != v {
			maj1 = v
			c1 = 1
		} else if c2 == 0 && maj1 != v {
			maj2 = v
			c2 = 1
		} else if maj1 == v {
			c1++
		} else if maj2 == v {
			c2++
		} else {
			c1--
			c2--
		}
		fmt.Println(maj1, maj2)
	}

	c1, c2 = 0, 0
	for _, v := range nums {
		if maj1 == v {
			c1++
		} else if maj2 == v {
			c2++
		}
	}

	res := make([]int, 0)
	if c1 > l/3 {
		res = append(res, maj1)
	}
	if c2 > l/3 {
		res = append(res, maj2)
	}
	return res
}

func main() {
	res := majorityElement([]int{1, 1, 1, 1, 2, 3, 3, 4, 5})
	fmt.Println(res)
}
