package day4;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
            {'A'},

        };
        String word = "A";
        System.out.println(exist(board,word));
    }

    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        if (m * n < word.length()) {
            return false;
        }
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < m ;j++){
                if(word.charAt(0) == board[i][j]){
                    if(dfs(board,i,j,visited,0,word))return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(char[][] board, int r , int c , boolean[][] visited,int targetIndex, String word){
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c])return false;
        if(word.charAt(targetIndex) == board[r][c] && targetIndex == word.length()  - 1)return true;
        if(word.charAt(targetIndex) != board[r][c]) return false;


        visited[r][c] = true;

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        for(int i = 0 ; i < 4; i++){
            int row = r + dx[i];
            int col = c + dy[i];
            if(dfs(board,row,col,visited,targetIndex + 1,word))return true;
        }
        visited[r][c] = false;
        return false;
    }

    //   public static boolean exist(char[][] board, String word) {
    //        int n = board.length;
    //        int m = board[0].length;
    //
    //        // Step 1: Check if the board can accommodate the word
    //        Map<Character, Integer> wordFreq = new HashMap<>();
    //        for (char ch : word.toCharArray()) {
    //            wordFreq.put(ch, wordFreq.getOrDefault(ch, 0) + 1);
    //        }
    //        Map<Character, Integer> boardFreq = new HashMap<>();
    //        for (int i = 0; i < n; i++) {
    //            for (int j = 0; j < m; j++) {
    //                char ch = board[i][j];
    //                boardFreq.put(ch, boardFreq.getOrDefault(ch, 0) + 1);
    //            }
    //        }
    //        for (char ch : wordFreq.keySet()) {
    //            if (wordFreq.get(ch) > boardFreq.getOrDefault(ch, 0)) {
    //                return false; // Not enough instances of a required character
    //            }
    //        }
    //
    //        // Step 2: Start search from both ends of the word
    //        if (search(board, word)) {
    //            return true;
    //        }
    //        // Reverse the word and search again
    //        StringBuilder reversedWord = new StringBuilder(word).reverse();
    //        return search(board, reversedWord.toString());
    //    }
    //
    //    private static boolean search(char[][] board, String word) {
    //        int n = board.length;
    //        int m = board[0].length;
    //        boolean[][] visited = new boolean[n][m];
    //
    //        // Step 3: Perform DFS with pruning based on character positions and frequencies
    //        for (int i = 0; i < n; i++) {
    //            for (int j = 0; j < m; j++) {
    //                if (board[i][j] == word.charAt(0)) {
    //                    if (dfs(board, i, j, visited, 0, word)) {
    //                        return true;
    //                    }
    //                }
    //            }
    //        }
    //        return false;
    //    }
    //
    //    private static boolean dfs(char[][] board, int r, int c, boolean[][] visited, int targetIndex, String word) {
    //        if (targetIndex == word.length()) {
    //            return true;
    //        }
    //        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c] || word.charAt(targetIndex) != board[r][c]) {
    //            return false;
    //        }
    //
    //        visited[r][c] = true;
    //
    //        int[] dx = { -1, 0, 1, 0 };
    //        int[] dy = { 0, 1, 0, -1 };
    //
    //        for (int i = 0; i < 4; i++) {
    //            int row = r + dx[i];
    //            int col = c + dy[i];
    //            if (dfs(board, row, col, visited, targetIndex + 1, word)) {
    //                return true;
    //            }
    //        }
    //
    //        visited[r][c] = false;
    //
    //        return false;
    //    }
}
