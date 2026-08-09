class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int i=0,j=0;
        int ans = 0;
        while(j<n) {
            k -= nums[j]==0 ? 1 : 0;  
            while(k<0) {
                k += nums[i]==0?1:0;
                i++;
              
            }
            ans = Math.max(ans, j-i+1);   
            j++;
        }
        return ans;
    }
}