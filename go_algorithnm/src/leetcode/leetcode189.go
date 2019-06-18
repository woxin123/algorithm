package main

import "fmt"

func rotate(nums []int, k int) {
	n := len(nums)
	k = k % n
	k = n - k
	if k == 0 || n == 0 || n == 1 {
		return
	}
	reverse(nums[:k])
	reverse(nums[k:])
	reverse(nums[:])
}

func reverse(nums []int) {
	n := len(nums)
	for i, j := 0, n-1; i < j; i, j = i+1, j-1 {
		nums[i], nums[j] = nums[j], nums[i]
	}
}

func main() {
	a := [...]int{1, 2, 3, 4, 5}
	rotate(a[:], 2)
	fmt.Println(a)
}
