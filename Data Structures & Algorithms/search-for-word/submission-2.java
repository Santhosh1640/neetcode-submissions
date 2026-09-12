class Solution {
    public boolean backtrack(char[][] board, int i, int j, int ind, String word, boolean[][] vis) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) {
            return false;
        }

        if(vis[i][j]) {
            return false;
        }

        if(board[i][j]!=word.charAt(ind)) {
            return false;
        }

        if(ind==word.length()-1) {
            return true;
        }

        vis[i][j] = true;
        boolean found = backtrack(board, i, j+1, ind+1, word, vis) ||
        backtrack(board, i, j-1, ind+1, word, vis) ||
        backtrack(board, i+1, j, ind+1, word, vis) ||
        backtrack(board, i-1, j, ind+1, word, vis);

        vis[i][j] = false;

        return found;

    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!vis[i][j]) {
                    if(backtrack(board, i, j, 0, word, vis)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
