class Solution {
    public int helper(int[] nums, int ind, int target, Map<String,Integer> dp) {
        if(ind==nums.length) {
            return (target==0)?1:0;
        }

        String key = ind+","+target;

        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        int add = helper(nums, ind+1, target+nums[ind], dp);
        int sub = helper(nums, ind+1, target-nums[ind], dp);

        int result = add+sub;
        dp.put(key,result);

        return result;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        Map<String,Integer> dp = new HashMap<>();

        return helper(nums, 0, target, dp);




    }
}
