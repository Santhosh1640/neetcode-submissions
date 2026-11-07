class Solution {
    
    public int helper(int ind, int[] nums, int[] dp) {
        if(ind>=nums.length-1) {
            return 0;
        }

        if(dp[ind]!=-1) {
            return dp[ind];
        }

        int minJumps = Integer.MAX_VALUE;

        for(int jump=1; jump<=nums[ind]; jump++) {
            int next = ind+jump;
            if(next <= nums.length-1) {
                int result = helper(ind+jump, nums, dp);
                if(result!=Integer.MAX_VALUE) {
                    minJumps = Math.min(1+result, minJumps);
                }
                
            }
        }
        return dp[ind] = minJumps;
    }
    public int jump(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return helper(0, nums, dp);
    }
}
