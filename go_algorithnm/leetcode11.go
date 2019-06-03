package main

import "math"

func maxArea(height []int) int {
	if len(height) == 0 {
		return 0
	}
	left, right := 0, len(height)-1
	maxArea := math.MinInt32
	for left < right {
		newArea := 0
		if height[left] < height[right] {
			newArea = height[left] * (right - left)
			left++
		} else {
			newArea = height[right] * (right - left)
			right--
		}
		if maxArea < newArea {
			maxArea = newArea
		}
	}
	return maxArea
}
