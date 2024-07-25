package day11;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestBridge {
    public static void main(String[] args) {
        int[][] grid = {{0,1},
                        {1,0}};
        System.out.println(shortestBridge(grid));
    }

    public static int shortestBridge(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        boolean flag = false;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    dfs(grid,i,j,vis);
                    flag = true;
                }
                if(flag)break;
            }
            if(flag)break;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m ; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    queue.add(new int[]{i,j,0});
                }
            }
        }

        while(!queue.isEmpty()){
            int row = queue.peek()[0];
            int col = queue.peek()[1];
            int flips = queue.peek()[2];
            int[] dx = {-1,0,1,0};
            int[] dy = {0,1,0,-1};
            for(int i = 0 ; i < 4; i++) {
                int r = row + dx[i] , c = col + dy[i];
                if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length){
                    if(grid[r][c] == 2 && vis[r][c]){
                        return flips;
                    }else if(!vis[r][c]){
                        queue.add(new int[]{r,c,flips + 1});
                    }
                }
            }
            queue.poll();
        }
        return 0;
    }
    public static void dfs(int[][] grid,int r , int c , boolean[][] vis){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || vis[r][c] || grid[r][c] == 0){
            return;
        }

        vis[r][c] = true;
        grid[r][c] = 2;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        for(int i = 0 ; i < 4; i++){
            int row = r + dx[i], col = c + dy[i];
            dfs(grid,row,col,vis);
        }
    }
}
