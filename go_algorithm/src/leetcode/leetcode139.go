package main

import (
	"fmt"
)

func wordBreak(s string, wordDict []string) bool {
	len := len(s)
	flags := make([]bool, len+1)
	flags[0] = true
	for i := 1; i <= len; i++ {
		for j := 0; j < i; j++ {
			if flags[j] && find(wordDict, s[j:i]) {
				flags[i] = true
				break
			}
		}
	}
	return flags[len]
}

func find(strs []string, s string) bool {
	for _, v := range strs {
		if v == s {
			return true
		}
	}
	return false
}

func main() {
	res := wordBreak("leetcode", []string{"leet", "code"})
	fmt.Println(res)
}