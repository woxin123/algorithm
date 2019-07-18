package main

import (
	"fmt"
	"container/list"
	"strings"
)

func calculate(s string) int {
	s = strings.Replace(s, " ", "", -1)
	s1 := list.New()
	s2 := list.New()
	num := 0
	for _, v := range s {
		if v <= '9' && v >= '0' {
			num *= 10
			num += int(v - '0')
		} else {
			s1.PushFront(num)
			num = 0
			if s2.Len() > 0 {
				sym := s2.Front().Value.(rune)
				for sym == '*' || sym == '/' || ((sym == '+' || sym == '-') &&
				(v == '+' || v == '-')) {
					x := s1.Front().Value.(int)
					s1.Remove(s1.Front())
					y := s1.Front().Value.(int)
					s1.Remove(s1.Front())	
					z := 0
					switch sym {
					case '+':
						z = y + x
					case '-':
						z = y - x
					case '*':
						z = y * x
					case '/':
						z = y / x
					}
					s1.PushFront(z)	
					s2.Remove(s2.Front())
					if s2.Len() > 0 {
						sym = s2.Front().Value.(rune)
					} else {
						break
					}
				}
			}
			s2.PushFront(v)
		}
	}
	s1.PushFront(num)
	for s2.Len() > 0 {
		x := s1.Front().Value.(int)
		s1.Remove(s1.Front())
		y := s1.Front().Value.(int)
		s1.Remove(s1.Front())
		sym := s2.Front().Value.(rune)
		s2.Remove(s2.Front())
		z := 0
		switch sym {
		case '+':
			z = y + x
		case '-':
			z = y - x
		case '*':
			z = y * x
		case '/':
			z = y / x
		}
		s1.PushFront(z)
	}
	return s1.Front().Value.(int)
}

func main() {
	res := calculate("1-1+1")
	fmt.Println(res)
}
