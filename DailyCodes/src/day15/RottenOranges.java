package day15;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid)
    {
        Queue<int[]> queue = new ArrayDeque<>();
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j,0});
                    vis[i][j] = true;
                }
            }
        }
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int res = 0;
        while(!queue.isEmpty()){
            int r = queue.peek()[0];
            int c = queue.peek()[1];
            int time = queue.poll()[2];
            res = Math.max(time,res);
            for(int i = 0 ; i < 4; i++){
                int row = r + dx[i], col = c + dy[i];
                if(row >= 0 && col >= 0 && row < n && col < m && !vis[row][col] && grid[row][col] != 0){
                    queue.add(new int[]{row,col,time + 1});
                    vis[row][col] = true;
                    grid[row][col] = 2;
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m; j++){
                if(grid[i][j] == 1 && !vis[i][j])return -1;
            }
        }
        return res;
    }
}
