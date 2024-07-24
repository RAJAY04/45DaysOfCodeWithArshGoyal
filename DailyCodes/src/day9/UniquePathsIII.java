package day9;

public class UniquePathsIII {
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        System.out.println(uniquePathsIII(grid));
    }

    static int ans;
    public static int uniquePathsIII(int[][] grid) {
        int n = grid.length,m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        ans = 0;
        int validCount = 0;
        int startX = 0, startY = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != -1) validCount++;
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }

        dfs(grid, startX, startY, validCount, visited);

        return ans;
    }
    public static void dfs(int[][] grid,int row ,int col,int validCount,boolean[][] vis){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || vis[row][col] || grid[row][col] == -1){
            return;
        }
        if(grid[row][col] == 2){
            if(validCount == 1){
                ans++;
            }
            return;
        }

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        vis[row][col] = true;
        for(int i = 0 ; i < 4; i++){
            int r = row + dx[i], c = col + dy[i];
            dfs(grid,r,c,validCount - 1,vis);

        }
        vis[row][col] = false;
    }

    public int uniquePathsIII1(int[][] grid) {//not my solution
        int zero = 0 , a = 0, b = 0 ;
        for(int r = 0; r < grid.length ; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 0)   zero++;
                else if(grid[r][c] == 1){
                    a = r;
                    b = c;
                }
            }
        }
        return path(grid, a, b, zero);
    }
    private int path(int[][] grid, int x, int y, int zero){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1)
            return 0;
        if(grid[x][y] == 2)
            return zero == -1 ? 1 : 0;
        grid[x][y] = -1;
        zero--;
        int totalCount = path(grid, x + 1, y, zero) + path(grid, x, y + 1, zero) +
                path(grid, x - 1, y, zero) + path(grid, x, y - 1, zero);
        grid[x][y] = 0;
        zero++;

        return totalCount;
    }
}
