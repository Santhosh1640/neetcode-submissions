class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxx = nums[0];
        int minn = nums[0];
        int ans = nums[0];


        for(int i=1; i<n; i++) {
            int x = nums[i];

            int tempMax = Math.max(x, Math.max(x*maxx, x*minn));
            int tempMin = Math.min(x, Math.min(x*maxx, x*minn));

            maxx = tempMax;
            minn = tempMin;

            ans = Math.max(ans, maxx);
        }

        return ans;
    }
}
