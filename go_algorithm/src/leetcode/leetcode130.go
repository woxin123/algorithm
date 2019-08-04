package main

import "fmt"

func solve(board [][]byte) {
	if len(board) == 0 {
		return
	}
	m, n := len(board), len(board[0])
	for i := 0; i < n; i++ {
		if board[0][i] == 'O' {
			dfs(board, 0, i, m, n)
		}
		if board[m-1][i] == 'O' {
			dfs(board, m-1, i, m, n)
		}
	}
	for i := 0; i < m; i++ {
		if board[i][0] == 'O' {
			dfs(board, i, 0, m, n)
		}
		if board[i][n-1] == 'O' {
			dfs(board, i, n-1, m, n)
		}
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if board[i][j] == 'O' {
				board[i][j] = 'X'
			}
			if board[i][j] == 'Y' {
				board[i][j] = 'O'
			}
		}
	}
}

func dfs(board [][]byte, x, y, m, n int) {
	if x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O' {
		return
	}
	board[x][y] = 'Y'
	dfs(board, x, y+1, m, n)
	dfs(board, x, y-1, m, n)
	dfs(board, x+1, y, m, n)
	dfs(board, x-1, y, m, n)
}

func main() {
	board := [][]byte{
		{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'},
	}
	solve(board)
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[0]); j++ {
			fmt.Printf("%c ", board[i][j])
		}
		fmt.Println()
	}
}
