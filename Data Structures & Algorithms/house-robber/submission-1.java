class Solution {
    int max = 0;
    public int helper(int[] nums, int ind, int n, int[] dp) {
        if(ind>=n) {
            return 0;
        }
        if(dp[ind]!=-1) {
            return dp[ind];
        }
        int rob = nums[ind] + helper(nums, ind+2, n, dp);
        int skip = helper(nums, ind+1, n, dp);

        dp[ind] = Math.max(rob, skip);
        return dp[ind];

    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums, 0, nums.length, dp);
    }
}
