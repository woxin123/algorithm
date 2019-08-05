package main

import "fmt"

func combinationSum(candidates []int, target int) [][]int {
	res := make([][]int, 0)
	return combinationSumHelp(candidates, target, 0, make([]int, 0), res)

}

func combinationSumHelp(candidates []int, current, index int, temp []int, res [][]int) [][]int {
	if current == 0 {
		r := make([]int, len(temp))
		copy(r, temp) 
		res = append(res, r)
		return res
	}
	if current < 0 {
		return res
	}
	for i := index; i < len(candidates); i++ {
		current -= candidates[i]
		temp = append(temp, candidates[i])
		res = combinationSumHelp(candidates, current, i, temp, res)
		temp = temp[:len(temp) - 1]
		current += candidates[i]
	}
	return res
}

func main() {
	res := combinationSum([]int{2, 3, 5}, 8)
	fmt.Println(res)
}
