class Solution {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        Boolean[][] dp = new Boolean[n][target + 1];
        return helper(nums, dp, 0, target);
    }

    public boolean helper(int[] nums, Boolean[][] dp,
                          int ind, int target) {

        if (target == 0) {
            return true;
        }

        if (ind == nums.length) {
            return false;
        }

        if (dp[ind][target] != null) {
            return dp[ind][target];
        }

        boolean pick = false;
        if (nums[ind] <= target) {
            pick = helper(nums, dp, ind + 1,
                          target - nums[ind]);
        }
        boolean notpick = helper(nums, dp, ind + 1, target);

        return dp[ind][target] = pick || notpick;
    }
}
