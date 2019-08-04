package main

import "fmt"

func subsets(nums []int) [][]int {
	res := make([][]int, 0)
	tmp := make([]int, 0)
	backTrace(0, &nums, &tmp, &res)
	return res
}

func backTrace(start int, nums *[]int, tmp *[]int, res *[][]int) {
	t := make([]int, 0)
	t = append(t, (*tmp)...)
	*res = append(*res, t)
	for i := start; i < len(*nums); i++ {
		*tmp = append(*tmp, (*nums)[i])
		backTrace(i+1, nums, tmp, res)
		*tmp = (*tmp)[:len(*tmp)-1]
	}
}

func main() {
	res := subsets([]int{1, 2, 3})
	fmt.Println(res)
}
