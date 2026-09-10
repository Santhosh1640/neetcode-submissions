class Solution {
    public boolean backtrack(char[][] board, int ind, int i, int j, boolean[][] vis, String word) {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) {
            return false;
        }

        if(vis[i][j]) {
            return false;
        }
        
        //if curr char doesnt match
        if(board[i][j] != word.charAt(ind)) {
            return false;
        }

        if(ind==word.length()-1) {
            return true;
        }

        vis[i][j] = true;

        boolean found = backtrack(board, ind+1, i, j+1, vis, word) ||
        backtrack(board, ind+1, i, j-1, vis, word) ||
        backtrack(board, ind+1, i+1, j, vis, word) ||
        backtrack(board, ind+1, i-1, j, vis, word);

        //Backtrack
        vis[i][j] = false;

        return found;
    }
    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++){
                if(backtrack(board, 0, i, j, vis, word)){
                    return true;
                }
            }
        }
        return false;

    }
}
