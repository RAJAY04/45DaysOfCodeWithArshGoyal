package day12;

public class ReplaceOsWithXs {
    public static void main(String[] args) {
        int n = 3, m = 3;
        char[][] a = {{'X','X','X'},{'X','O','X'},{'X','X','X'}};
        char[][] res = fill(n,m,a);
        for(int i = 0 ; i < res.length; i++){
            for(int j = 0 ; j < res[0].length; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    static char[][] fill(int n, int m, char a[][])
    {
        boolean[][] vis = new boolean[n][m];
        for(int i = 0 ; i < m; i++){
            if(!vis[0][i] && a[0][i] == 'O'){
                dfs(a,0,i,vis);
            }

            if(!vis[n - 1][i] && a[n - 1][i] == 'O'){
                dfs(a,n - 1, i, vis);
            }
        }

        for(int i = 0 ;i < n; i++){
            if(!vis[i][0] && a[i][0] == 'O'){
                dfs(a,i,0,vis);
            }

            if(!vis[i][m - 1] && a[i][m - 1] == 'O'){
                dfs(a,i,m - 1,vis);
            }
        }

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ;j < m ;j++){
                if(a[i][j] == 'O' && !vis[i][j]){
                    a[i][j] = 'X';
                }
            }
        }
        return a;
    }

    public static void dfs(char[][] grid, int r,int c,boolean[][] vis){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || vis[r][c] || grid[r][c] == 'X')return;
        vis[r][c] = true;

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        for(int i = 0 ; i < 4; i++){
            int row = r + dx[i];
            int col = c + dy[i];
            dfs(grid,row,col,vis);
        }
    }
}
