package main

func lengthOfLongestSubstring(s string) int {
	iMap := make(map[byte]bool)
	i, j, res := 0, 0, 0
	n := len(s)
	for i < n && j < n {
		if _, ok := iMap[s[j]]; !ok {
			iMap[s[j]] = true
			j++
			if res < j-i {
				res = j - i
			}
		} else {
			delete(iMap, s[i])
			i++
		}
	}
	return res
}
