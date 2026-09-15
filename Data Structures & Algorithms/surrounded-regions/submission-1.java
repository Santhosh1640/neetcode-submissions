class Solution {
    public void dfs(char[][] board, int i, int j, int n, int m) {
        if(i<0 || i>=n || j<0 || j>=m || board[i][j]!='O') {
            return;
        }
        board[i][j]='#';
        int[] r = {0,-1,0,1};
        int[] c = {-1,0,1,0};

        for(int k=0; k<4; k++) {
            int row = r[k]+i;
            int col = c[k]+j;
            dfs(board, row, col, n, m);
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        //Left and right borders
        for(int i=0; i<n; i++) {
            if(board[i][0]=='O') {
                dfs(board, i, 0, n, m);
            }
            
            if(board[i][m-1]=='O') {
                dfs(board, i, m-1, n, m);
            }
        }

        //Top and Bottom borders
        for(int i=0; i<m; i++) {
            if(board[0][i]=='O') {
                dfs(board, 0, i, n, m);
            }
            if(board[n-1][i]=='O') {
                dfs(board, n-1, i, n, m);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
