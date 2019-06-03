package main

import "fmt"

func intToRoman(num int) string {
	values := []int{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}
	strs := []string{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}
	res := ""
	for i := 0; ; {
		if num >= values[i] {
			num -= values[i]
			res += strs[i]
		} else {
			i++
		}
		fmt.Println(values[i])
		if num == 0 {
			break
		}
	}
	return res
}

func main() {
	x := intToRoman(320)
	fmt.Println(x)
}
