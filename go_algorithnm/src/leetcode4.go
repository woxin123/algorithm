package main


func longestPalindrome(s string) string {
	if len(s) == 0 {
		return ""
	}
	start, end := 0, 0
	for i := range s {
		len1 := expandLeftAndRight(s, i, i)
		len2 := expandLeftAndRight(s, i, i+1)
		len := len2
		if len1 > len2 {
			len = len1
		}
		if len > end - start {
			start = i - (len-1)/2
			end = i + len/2
		}
	}
	return s[start:end + 1]
}

func expandLeftAndRight(s string, left, right int) int {
	for left >= 0 && right < len(s) && s[left] == s[right] {
		left--
		right++
	}
	return right - left - 1
}
