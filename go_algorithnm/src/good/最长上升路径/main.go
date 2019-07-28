package main

import "fmt"

var direction = [][]int{
	{0, 1}, {0, -1}, {1, 0}, {-1, 0},
}

func longestIncreasingPath(matrix [][]int) int {
	if len(matrix) == 0 {
		return 0
	}
	m := len(matrix)
	n := len(matrix[0])
	cache := make([][]int, m)
	for i := 0; i < m; i++ {
		cache[i] = make([]int, n)
	}
	res := 0
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			cache[i][j] = dfs(matrix, cache, i, j)
			if res < cache[i][j] {
				res = cache[i][j]
			}
		}
	}
	return res
}

func dfs(matrix [][]int, cache [][]int, x, y int) int {
	if cache[x][y] != 0 {
		return cache[x][y]
	}
	res := 1
	for _, d := range direction {
		
		nx := x + d[0]
		ny := y + d[1]
		
		if nx < 0 || ny < 0 || nx >= len(matrix) || ny >= len(matrix[0]) || matrix[x][y] <= matrix[nx][ny] {
			continue
		}
		tmp := dfs(matrix, cache, nx, ny) + 1
		if res < tmp {
			res = tmp
		}
	}
	cache[x][y] = res

	return res
}

func main() {
	data := [][]int{
		{3,4,5},
		{3,2,6},
		{2,2,1},
	}
	res := longestIncreasingPath(data)
	fmt.Println(res)
}