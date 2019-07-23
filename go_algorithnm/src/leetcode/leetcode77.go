package main

import "fmt"

func combine(n int, k int) [][]int {
	res := make([][]int, 0)
	nums := make([]int, 0)
	backTrace(1, k, n, &res, &nums)
	return res
}

func backTrace(start int, k, n int, res *[][]int, nums *[]int) {
	if len(*nums) == k {
		tmp := make([]int, 0)
		tmp = append(tmp, (*nums)...)
		*res = append(*res, tmp)
	}

	for i := start; i <= n; i++ {
		*nums = append(*nums, i)
		backTrace(i+1, k, n, res, nums)
		*nums = (*nums)[:len(*nums)-1]
	}
}

func main() {
	res := combine(5, 3)
	fmt.Println(res)
}
