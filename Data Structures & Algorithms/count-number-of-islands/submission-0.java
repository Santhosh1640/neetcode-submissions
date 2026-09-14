class Solution {
    public void helper(char[][] grid, int i, int j, int n, int m, boolean[][] vis) {
        vis[i][j] = true;
        int[] r = {0,-1,0,1};
        int[] c = {-1,0,1,0};

        for(int k=0; k<4; k++) {
            int row = i+r[k];
            int col = j+c[k];

            if(row>=0 && row<n && col>=0 && col<m && grid[row][col]=='1' && !vis[row][col]) {
                vis[row][col] = true;
                helper(grid, row, col, n, m, vis);
            }
        }

    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int cnt = 0;

        boolean[][] vis = new boolean[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!vis[i][j] && grid[i][j]=='1') {
                    cnt++;
                    helper(grid, i, j, n, m, vis);
                }
            }
        }
        return cnt;
    }
}
