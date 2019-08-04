package main

import (
	"fmt"
)

func longestPalindrome(s string) string {
	if len(s) <= 1 {
		return s
	}
	longest := 1
	l := len(s)
	dp := make([][]bool, l)
	for i := 0; i < l; i++ {
		tmp := make([]bool, l)
		dp[i] = tmp
	}
	longStr := s[0:1]
	for i := 1; i < l; i++ {
		for j := 0; j < i; j++ {
			if (s[j] == s[i] && (i - j <= 2 || dp[j + 1][i - 1])) {
				dp[j][i] = true
				if i - j + 1 > longest {
					longest = i - j + 1
					longStr = s[j:i+1]
				}
			}
		}
	}
	return longStr
}

func main() {
	res := longestPalindrome("bababa")
	fmt.Println(res)
}
