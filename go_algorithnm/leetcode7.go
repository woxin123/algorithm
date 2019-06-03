package main

import (
	"fmt"
	"math"
)

func reverse(x int) int {
	if x == 0 {
		return 0
	}
	var flag bool
	if x < 0 {
		flag = false
		x = -x
	} else {
		flag = true
	}
	res := 0
	for x != 0 {
		res *= 10
		res += x % 10
		x = x / 10
	}
	if flag {
		if res > math.MaxInt32 {
			return 0
		}
		return res
	} else {
		if -res < math.MinInt32 {
			return 0
		}
		return -res
	}
}

func main() {
	x := reverse(-1234)
	fmt.Println(x)
	fmt.Println(math.MaxInt32)
}
