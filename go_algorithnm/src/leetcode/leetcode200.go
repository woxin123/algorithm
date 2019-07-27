package main

import "fmt"

var direction = [4][2]int{
	{0, 1}, {0, -1}, {1, 0}, {-1, 0},
}

func numIslands(grid [][]byte) int {
	nums := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {

			if grid[i][j] == '1' {
				dfs(grid, i, j)
				nums++
			}
		}
	}
	return nums
}

func dfs(grid [][]byte, x, y int) {
	grid[x][y] = '0'
	for i := 0; i < 4; i++ {
		x = x + direction[i][0]
		y = y + direction[i][1]

		if x < 0 || y < 0 || x >= len(grid) || y >= len((grid)[0]) {
			continue
		}
		if grid[x][y] == '1' {
			dfs(grid, x, y)
		}
	}
}

func main() {
	grid := [][]byte{
		// {'1', '1', '1', '1', 0}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'},
		{'1'}, {'1'},
	}
	res := numIslands(grid)
	fmt.Println(res)
}
