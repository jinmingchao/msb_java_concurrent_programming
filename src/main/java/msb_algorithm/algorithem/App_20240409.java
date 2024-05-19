package msb_algorithm.algorithem;

public class App_20240409 {
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    char cross = 'X', circle = 'O';

    public void solve(char[][] board) {
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1) {
                    bfs(i, j , board, visited);
                } else {
                    if (j == 0 || j == col - 1) {
                        bfs(i, j , board, visited);
                    }
                }
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (!visited[i][j] && board[i][j] == circle) {
                      board[i][j] = cross;
                }
            }
        }
    }

    void bfs(int r, int c, char[][] board, boolean[][] visited) {
        int[] pos = new int[]{r, c};
        if (pos[0] == -1 || pos[0] == board.length || pos[1] == -1 || pos[1] == board[0].length) return;
        if (visited[pos[0]][pos[1]]) return;
        visited[pos[0]][pos[1]] = true;
        if (board[pos[0]][pos[1]] == cross) {
            return;
        }

        for (int i = 0 ; i < directions.length; i++) {
            int x = pos[0] +directions[i][0];
            int y = pos[1] +directions[i][1];
            bfs(x, y, board, visited);
        }
    }
}
