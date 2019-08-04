package main

func romanToInt(s string) int {
	romanNum := map[string]int16 {
		"I": 1,
		"IV": 4,
		"V": 5,
		"IX": 9,
		"X": 10,
		"XL": 40,
		"L": 50,
		"XC": 90,
		"C": 100,
		"CD": 400,
		"D": 500,
		"CM": 900,
		"M": 1000,
	}
	var res int
	var v int16
	var ok bool
	for i := len(s) - 1; i >= 0; i-- {
		ok = false
		if i > 0 {
			v, ok = romanNum[s[i - 1:i + 1]]
		}
		if ok {
			res += int(v)
			i--
		} else {
			v, ok = romanNum[s[i:i+1]]
			if ok {
				res += int(v)
			} else {
				return 0
			}
		}
	}
	return res
}
