class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int l=0,r=1;
        int n = nums.length;

        while(r<n) {
            if(nums[l]==nums[r]) {
                return nums[l];
            }
            l++;
            r++;
        }
        return -1;
    }
}
