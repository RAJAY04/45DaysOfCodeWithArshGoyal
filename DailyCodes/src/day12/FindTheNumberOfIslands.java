package day12;

public class FindTheNumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},
                {'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length , m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int islands = 0;
        for(int i = 0 ;i < n; i++){
            for(int j = 0; j < m ;j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    dfs(grid,i,j,vis);
                    islands++;
                }
            }
        }
        return  islands;
    }
    public static void dfs(char[][] grid, int r,int c,boolean[][] vis){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || vis[r][c] || grid[r][c] == '0')return;
        vis[r][c] = true;

        int[] dx = {-1,-1,-1,0,1,1,1,0};
        int[] dy = {-1,0,1,1,1,0,-1,-1};
        for(int i = 0 ; i < 8; i++){
            int row = r + dx[i];
            int col = c + dy[i];
            dfs(grid,row,col,vis);
        }
    }

}
