package day5;

public class GameOfLIfe {
    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
    }

    public static void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[] dx = {-1,-1,-1,0,1,1,1,0};
        int[] dy = {-1,0,1,1,1,0,-1,-1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int neighbourOnes = 0;
                for (int k = 0; k < 8; k++) {
                    int r = i + dx[k];
                    int c = j + dy[k];
                    if (r >= 0 && r < n && c >= 0 && c < m && (board[r][c] == 1 || board[r][c] == 2)) {
                        neighbourOnes++;
                    }
                }

                if (board[i][j] == 1 && (neighbourOnes < 2 || neighbourOnes > 3)) {
                    // Mark as 2 (alive -> dead)
                    board[i][j] = 2;
                } else if (board[i][j] == 0 && neighbourOnes == 3) {
                    // Mark as 3 (dead -> alive)
                    board[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0; // Alive -> Dead
                } else if (board[i][j] == 3) {
                    board[i][j] = 1; // Dead -> Alive
                }
            }
        }
    }
}
