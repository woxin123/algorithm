package main

/*
 * 两数之和
 */

func twoSum(nums []int, target int) []int {
	numMap := make(map[int]int)
	for index, value := range nums {
		tmp := target - value
		if v, ok := numMap[tmp]; ok {
			return []int{v, index}
		}
		numMap[value] = index
	}
	return nil
}

func main() {
	
}
