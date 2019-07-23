package main

import "fmt"

func addDigits(num int) int {
	a := 0
	for {
		a += num % 10
		num = num / 10
		if num == 0 {
			num = a
			if num < 10 {
				break
			}
			a = 0
		}
	}
	return num
}

func addDigits2(num int) int {
	return (num - 1) % 9 + 1
}

func main() {
	res := addDigits2(999)
	fmt.Println(res)
}
