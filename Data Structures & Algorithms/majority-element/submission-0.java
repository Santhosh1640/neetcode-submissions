class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int cnt = 1;
        int i = 1;

        while(i<n) {
            if(nums[i]==ans) {
                cnt++;
            }
            else {
                cnt--;
            }
            if(cnt<0) {
                ans = nums[i];
            }
            i++;
        }
        return ans;
    }
}