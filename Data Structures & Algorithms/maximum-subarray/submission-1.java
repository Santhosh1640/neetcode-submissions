class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int i=0,j=0;
        int sum = 0;

        while(j<n) {
            if(sum<0) {
                sum = 0;
            }
            sum+=nums[j];
            ans = Math.max(ans, sum);
            j++;
        }
        return ans;
    }
}
