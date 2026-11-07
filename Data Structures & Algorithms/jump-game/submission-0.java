class Solution {
    public boolean helper(int ind, int[] nums, Boolean[] dp) {
        if(ind>=nums.length-1) {
            return true;
        }

        if(dp[ind]!=null) {
            return dp[ind];
        }

        for(int jump=1; jump<=nums[ind]; jump++) {
            if(helper(ind+jump, nums, dp)) {
                return dp[ind] = true;
            }
        }
        return dp[ind] = false;
    }
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length+1];

        return helper(0, nums, dp);
    }
}
