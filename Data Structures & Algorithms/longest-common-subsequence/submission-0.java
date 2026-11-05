class Solution {
    public int helper(int i, int j, int n1, int n2, String s1, String s2, int[][] dp) {
        if(i>=n1 || j>=n2) {
            return 0;
        }

        if(dp[i][j]!=-1) {
            return dp[i][j];
        }
        int result;
        if(s1.charAt(i)==s2.charAt(j)) {
            result = 1+helper(i+1, j+1, n1, n2, s1, s2, dp);
        }
        else {
            int skip1 = helper(i+1,j,n1,n2,s1,s2,dp);
            int skip2 = helper(i,j+1,n1,n2,s1,s2,dp);
            result = Math.max(skip1, skip2);
        }

        return dp[i][j] = result;


    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1][n2];

        for(int[] row:dp) {
            Arrays.fill(row,-1);
        }

        return helper(0,0,n1,n2,text1, text2,dp);


    }
}
