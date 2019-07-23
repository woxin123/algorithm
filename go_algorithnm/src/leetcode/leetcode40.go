package main

import (
	"fmt"
	"sort"
)

func combinationSum2(candidates []int, target int) [][]int {
	sort.Ints(candidates)
	fmt.Println(candidates)
	res := make([][]int, 0)
	temp := make([]int, 0)
	combinationSumHelp(candidates, target, 0, &temp, &res)
	return res
}

func combinationSumHelp(candidates []int, current, index int, temp *[]int, res *[][]int) {
	if current == 0 {
		r := make([]int, len(*temp))
		copy(r, *temp)
		*res = append(*res, r)
		return
	}
	if current < 0 {
		return
	}
	for i := index; i < len(candidates); i++ {
		if i > index && candidates[i] == candidates[i-1] {
			continue
		}
		*temp = append(*temp, candidates[i])
		combinationSumHelp(candidates, current - candidates[i], i+1, temp, res)
		*temp = (*temp)[:len(*temp)-1]
	}
}

func main() {
	res := combinationSum2([]int{10, 1, 2, 7, 6, 1, 5}, 8)
	fmt.Println(res)
}
