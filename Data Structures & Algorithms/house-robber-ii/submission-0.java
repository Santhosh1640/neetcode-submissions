class Solution {
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
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(helper(nums, 0, n-1, dp1), helper(nums, 1, n, dp2));
        
    }
}
