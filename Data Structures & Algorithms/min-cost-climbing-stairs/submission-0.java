class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp,0);
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<n;i++){
            int fs = dp[i-1]+cost[i];
            int ss = dp[i-2]+cost[i];        
            dp[i] = Math.min(fs,ss);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}