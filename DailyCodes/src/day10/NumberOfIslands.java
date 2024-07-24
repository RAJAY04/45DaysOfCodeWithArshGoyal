package day10;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        int islands = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    islands++;
                    dfs(grid,i,j,vis);
                }
            }
        }
        return islands;
    }

    public static void dfs(char[][] grid,int r,int c ,boolean[][] vis){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || vis[r][c] || grid[r][c] == '0')return;
        vis[r][c] = true;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        for(int i = 0 ; i < 4; i++){
            int curRow = dx[i] + r;
            int curCol = dy[i] + c;
            dfs(grid,curRow,curCol,vis);
        }
    }

}
