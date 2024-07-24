package day10;

import java.util.ArrayList;

public class RatInAMazeProblemI {
    public static void main(String[] args) {
        int[][] mat = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        System.out.println(findPath(mat));
    }

    public static ArrayList<String> findPath(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        if(mat[n - 1][m - 1] == 0 || mat[0][0] == 0)return new ArrayList<>();
        boolean[][] vis = new boolean[n][m];
        ArrayList<String> list = new ArrayList<>();
        dfs(mat,0,0,vis,new StringBuilder(),list);
        return list;
    }
    public static void dfs(int[][] mat,int r, int c,boolean[][] vis,StringBuilder sb,ArrayList<String> res){
        if(r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || vis[r][c] || mat[r][c] == 0)return;
        if(r == mat.length -1 && c == mat[0].length - 1){
            res.add(sb.toString());
            return;
        }

        vis[r][c] = true;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        char[] dir = {'U','R','D','L'};
        for(int i = 0 ; i < 4; i++){
            int curRow = dx[i] + r;
            int curCol = dy[i] + c;
            sb.append(dir[i]);
            dfs(mat,curRow,curCol,vis,sb,res);
            sb.deleteCharAt(sb.length() - 1);
        }
        vis[r][c] = false;
    }
}
