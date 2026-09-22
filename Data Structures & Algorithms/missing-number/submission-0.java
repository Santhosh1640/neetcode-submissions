class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int a = 0,b = 0;
        for(int i=0; i<=n; i++) {
            a^=i;
            if(i!=n) {
                b^=nums[i];
            }
        }
        return a^b;
    }
}
