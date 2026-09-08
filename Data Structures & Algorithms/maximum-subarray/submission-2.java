class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxx = Integer.MIN_VALUE;

        for(int num:nums) {
            sum+=num;
            maxx = Math.max(maxx, sum);

            if(sum<0) {
                sum = 0;
            }
        }
        return maxx;
    }
}
