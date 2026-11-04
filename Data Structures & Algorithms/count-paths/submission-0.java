class Solution {
    public int helper(int r, int c, int m, int n, int[][] dp) {
        if(r==m-1 && c==n-1) {
            return 1;
        }
        if(dp[r][c]!=-1) {
            return dp[r][c];
        }

        int right = 0, down = 0;

        if(c<n) {
            right = helper(r, c+1, m, n, dp);
        }
        if(r<m) {
            down = helper(r+1, c, m, n, dp);
        }

        return dp[r][c] = right+down;

    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] row:dp) {
            Arrays.fill(row, -1);
        }

        return helper(0, 0, m, n, dp);

    }
}
