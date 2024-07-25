package day11;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, newColor = 2;
        int[][] res = floodFill(image,sr,sc,newColor);
        for(int i = 0 ; i < res.length; i++){
            for(int j = 0 ; j < res[0].length; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length , m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        if(image[sr][sc] == color)return image;
        dfs(image,sr,sc,color,image[sr][sc],vis);
        return image;
    }

    public static void dfs(int[][] grid,int r, int c,int color, int sColor , boolean[][] vis){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || vis[r][c] || grid[r][c] != sColor){
            return;
        }

        vis[r][c] = true;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        for(int i = 0 ; i < 4; i++){
            int row = r + dx[i], col = c + dy[i];
            dfs(grid,row,col,color,sColor,vis);
        }
    }
}
