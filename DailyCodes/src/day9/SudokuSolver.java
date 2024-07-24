package day9;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    public static void solveSudoku(char[][] board) {
        Set<Character>[][] blockSet = new Set[3][3];
        Set<Character>[] rowSet = new Set[9];
        Set<Character>[] colSet = new Set[9];
        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                blockSet[i][j] = new HashSet<>();
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    char num = board[i][j];
                    rowSet[i].add(num);
                    colSet[j].add(num);
                    blockSet[i / 3][j / 3].add(num);
                }
            }
        }

        solve(board, 0, 0, rowSet, colSet, blockSet);
    }

    public static boolean solve(char[][] board, int r, int c, Set<Character>[] rowSet, Set<Character>[] colSet, Set<Character>[][] blocks) {

        if(r == 9)return true;
        if(c == 9)return solve(board,r + 1,0,rowSet,colSet,blocks);
        if(board[r][c] != '.')return solve(board,r,c + 1,rowSet,colSet,blocks);

        for (char num = '1'; num <= '9'; num++) {
            if (!rowSet[r].contains(num) && !colSet[c].contains(num) && !blocks[r / 3][c / 3].contains(num)) {
                board[r][c] = num;
                rowSet[r].add(num);
                colSet[c].add(num);
                blocks[r / 3][c / 3].add(num);

                if (solve(board, r, c + 1, rowSet, colSet, blocks)) return true;

                board[r][c] = '.';
                rowSet[r].remove(num);
                colSet[c].remove(num);
                blocks[r / 3][c / 3].remove(num);

            }

        }
        return false;
    }

    public void solveSudoku1(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board){
        for(int row = 0 ; row < board.length; row++){
            for(int col = 0 ; col < board[0].length ; col++){
                if(board[row][col] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isSafe(board,row,col,c)){
                            board[row][col] = c;

                            if(solve(board)){
                                return true;
                            }else board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSafe(char[][] board,int row, int col, char c){
        for(int i = 0 ; i < 9 ; i++){
            if(board[row][i] == c)return false;
            if(board[i][col] ==  c)return false;
            if(board[3 * (row/3 )+ i/3][3 * (col/3) + i%3] == c)return false;
        }
        return true;
    }
}
