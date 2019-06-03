package main

import (
	"fmt"
	"math"
	"strings"
)

func myAtoi(str string) int {
	str = strings.Trim(str, " ")
	if str == "" {
		return 0
	}
	var flag bool = true
	var res int = 0
	if str[0:1] == "-" {
		str = str[1:]
		flag = false
	} else if str[0:1] == "+" {
		str = str[1:]
		flag = true
	}
	for _, v := range str {
		if v > '9' || v < '0' {
			break
		}
		res *= 10
		res += int(v - '0')
		if flag && res > math.MaxInt32 {
			return math.MaxInt32
		} else if -res < math.MinInt32 {
			return math.MinInt32
		}
	}
	fmt.Println(flag)
	if flag {
		return res
	}
	return -res

}

func main() {
	x := myAtoi("9223372036854775808")
	fmt.Println(x)
}
