class Solution {
    public int helper(int ind, int prev, int[] nums, int[][] dp, int n) {
        //Base case
        if(ind==n) {
            return 0;
        }
        if(dp[ind][prev+1]!=-1) {
            return dp[ind][prev+1];
        }
        int notpick = helper(ind+1, prev, nums, dp, n);
        int pick = 0;
        if(prev==-1 || nums[ind]>nums[prev]) {
            pick = 1+helper(ind+1, ind, nums, dp, n);
        }
        return dp[ind][prev+1] = Math.max(pick, notpick);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] a:dp) {
            Arrays.fill(a, -1);
        }
        return helper(0, -1, nums, dp, n);
    }
}