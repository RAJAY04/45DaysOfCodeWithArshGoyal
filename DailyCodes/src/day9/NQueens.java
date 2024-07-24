package day9;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = createAndInitialiseBoard(n);
        backtrack(board,0,res);
        return res;
    }
    public static void backtrack(char[][] board,int row ,List<List<String>> res){
        if(row == board.length){
            res.add(new ArrayList<>(addAnswer(board)));
            return;
        }
        for(int col = 0; col < board[0].length; col++){
            if(isValid(board,row,col)){
                board[row][col] = 'Q';
                backtrack(board,row + 1,res);
                board[row][col] = '.';
            }
        }
    }
    public static List<String> addAnswer(char[][] board){
        List<String> list = new ArrayList<>();
        for(char[] row : board){
            list.add(new String(row));
        }
        return list;
    }
    public static char[][] createAndInitialiseBoard(int n){
        char[][] board = new char[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ;j < n ; j++){
                board[i][j] = '.';
            }
        }
        return board;
    }
    public static boolean isValid(char[][] board,int r , int c){
        int row = r, col = 0;
        while(col < board.length){//horizontal
            if(board[row][col++] == 'Q')return false;
        }

        col = c;
        while(row >= 0){
            if(board[row--][col] == 'Q')return false;
        }

        row = r;
        col = c;
        while(row >= 0 && col >= 0){
            if(board[row--][col--] == 'Q')return false;
        }

        row = r;
        col = c;
        while(row >= 0 && col < board.length){
            if(board[row--][col++] == 'Q')return false;
        }
        return true;
    }
}
