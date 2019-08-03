package main

import (
	"fmt"
)

func searchMatrix(matrix [][]int, target int) bool {
	if len(matrix) == 0 {
		return false
	}
	short := len(matrix)
	if short > len(matrix[0]) {
		short = len(matrix[0])
	}
	for i := 0; i < short; i++ {
		vertical :=	binarySearch(matrix, i, target, true)
		horizontal := binarySearch(matrix, i, target, false)
		if vertical || horizontal {
			return true
		}
	}
	return false
}

func binarySearch(matrix [][]int, start, target int, vertical bool) bool {
	lo := start
	hi := len(matrix)-1
	if vertical {
		hi = len(matrix[0])-1
	}
	var mid int
	for lo < hi {
		mid = (lo+hi)/2
		if vertical {
			if matrix[start][mid] > target {
				hi = mid-1
			} else if matrix[start][mid] < target{
				lo = mid+1
			} else {
				return true
			}
		}	else {
			if matrix[mid][start] > target {
				hi = mid-1
			} else if matrix[mid][start] < target {
				lo = mid+1
			} else {
				return true
			}
		}
	}
	return false
}

func main() {
	data := [][]int{
		{1,   4,  7, 11, 15},
		{2,   5,  8, 12, 19},
		{3,   6,  9, 16, 22},
		{10, 13, 14, 17, 24},
		{18, 21, 23, 26, 30},
	}
	res := searchMatrix(data, 17)
	fmt.Println(res)
}
