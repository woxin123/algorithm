package main

func convert(s string, numRows int) string {
	index := 0
	strs := make([]string, numRows)
	var res string
	for {
		for i := 0; i < numRows && index < len(s); i++ {
			strs[i] += s[index:index+1]
			index++
		}
		for i := numRows - 2; i > 0 && index < len(s); i-- {
			strs[i] += s[index:index+1]
			index++
		}
		if index >= len(s) {
			break
		}
	}
	for i := 0; i < numRows; i++ {
		res += strs[i]
	}
	return res
}

