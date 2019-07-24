package main

import (
	"fmt"
	"strings"
)

func isPalindrome(s string) bool {
	ss := ""
	for i, v := range s {
		if (v >= '0' && v <= '9') || (v >= 'a' && v <= 'z') || (v >= 'A' && v <= 'Z') {
			ss += s[i : i+1]
		}
	}
	ss = strings.ToLower(ss)
	fmt.Println(ss)
	l := len(ss)
	for i := 0; i < l/2; i++ {
		if ss[i] != ss[l-i-1] {
			return false
		}
	}
	return true
}

func main() {
	res := isPalindrome("aav")
	fmt.Println(res)
}
