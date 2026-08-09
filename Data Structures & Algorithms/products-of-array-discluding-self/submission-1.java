class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prodAll = 1;
        int prodNonZero = 1;
        int zeroCount = 0;
        int[] ans = new int[n];
        for(int num: nums) {
            prodAll *= num;
            if(num!=0) {prodNonZero *= num;}
            else {zeroCount++;}
        }
        for(int i=0; i<n; i++) {
            if(zeroCount > 1) {
                ans[i] = 0;
            }
            else if(zeroCount == 1) {
                ans[i] = nums[i]==0 ? prodNonZero : 0;
            }
            else {
                ans[i] = prodAll/nums[i];
            }
            
        }
        return ans;
    }
}  
