package main

import "fmt"

func partition(s string) [][]string {
	res := make([][]string, 0)
	tmp := make([]string, 0)
	backTrace(s, 0, &res, &tmp)
	return res
}

func backTrace(s string, first int, res *[][]string, tmp *[]string) {
	if first == len(s) {
		tmp1 := make([]string, 0)
		tmp1  = append(tmp1, (*tmp)...)
		*res = append(*res, tmp1)
		return
	}
	for i := first; i < len(s); i++ {
		if isPalindrome(s[first : i+1]) {
			*tmp = append(*tmp, s[first:i+1])
			backTrace(s, i+1, res, tmp)
			*tmp = (*tmp)[:len(*tmp)-1]
		}
	}
}

func isPalindrome(s string) bool {
	l := len(s)
	for i := 0; i < l/2; i++ {
		if s[i] != s[l-i-1] {
			return false
		}
	}
	return true
}

func main() {
	res := partition("aab")
	fmt.Println(res)
}
