class Solution {
    public int helper(String s, int ind, int n, int[] dp) {
        if(ind>=n) {
            return 1;
        }

        if(s.charAt(ind)=='0') {
            return 0;
        }

        if(dp[ind]!=-1) {
            return dp[ind];
        }

        int ways = helper(s, ind+1, n, dp);
        if(ind+1<n && Integer.parseInt(s.substring(ind, ind+2))<=26) {
            ways+=helper(s, ind+2, n, dp);
        }
        return dp[ind] = ways;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(s, 0, s.length(), dp);
    }
}
