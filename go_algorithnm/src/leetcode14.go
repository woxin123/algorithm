package main

import (
	"container/list"
	"fmt"
)

// 解法1：水平扫描法
// func longestCommonPrefix(strs []string) string {
// 	if len(strs) == 0 {
// 		return ""
// 	}
// 	prefix := strs[0]
// 	for i := 1; i < len(strs); i++ {
// 		for strings.Index(strs[i], prefix) != 0 {
// 			prefix = prefix[0 : len(prefix)-1]
// 		}
		
// 	}
// 	return prefix
// }

// 水平扫描
// func longestCommonPrefix(strs []string) string {
// 	if len(strs) == 0 {
// 		return ""
// 	}
// 	var c string
// 	for i := 0; i < len(strs[0]); i++ {
// 		c = strs[0][i:i+1]
// 		for j := 1; j < len(strs); j++ {
// 			if i == len(strs[j]) || strs[j][i:i+1] != c {
// 				return strs[0][0:i]
// 			} 
// 		}
// 	}
// 	return strs[0]
// }

// 分治 递归写法
// func longestCommonPrefix(strs []string) string {
// 	if len(strs) == 0 {
// 		return ""
// 	}
// 	return lonegestCommonPrefixHelp(strs, 0, len(strs) - 1)
// }

// 分支 栈
// func longestCommonPrefix(strs []string) string {
// 	if len(strs) == 0 {
// 		return ""
// 	}
// 	stack := list.New()
// 	for i := 0; i < len(strs); i++ {
// 		stack.PushBack(strs[i])
// 	}
// 	for stack.Len() > 1 {
// 		e1 := stack.Back()
// 		stack.Remove(e1)
// 		e2 := stack.Back()
// 		stack.Remove(e2)
// 		stack.PushFront(commonPrefix(e1.Value.(string), e2.Value.(string)))
// 	}
// 	return stack.Back().Value.(string)
// }

// func lonegestCommonPrefixHelp(strs[] string, s, e int) string {
// 	if s == e {
// 		return strs[s]
// 	}
// 	mid := (s+e)/2
// 	ss := lonegestCommonPrefixHelp(strs, s, mid)
// 	se := lonegestCommonPrefixHelp(strs, mid+1, e)
// 	return commonPrefix(ss, se)
// }

// // 分支 栈
// func commonPrefix(s, e string) string {
// 	var mLen = len(s)
// 	if eLen := len(e); mLen > len(e) {
// 		mLen = eLen
// 	}
// 	for i := 0; i < mLen; i++ {
// 		if s[i:i+1] != e[i:i+1] {
// 			return s[0:i]
// 		}
// 	}
// 	return s[0:mLen]
// }

// 

