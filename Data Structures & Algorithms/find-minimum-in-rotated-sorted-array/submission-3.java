class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n-1;
        int minn = Integer.MAX_VALUE;

        while(i<j) {
            int mid = (i+j)/2;

            if(nums[mid] > nums[j]) {
                i = mid + 1;
            }
            else {
                j = mid;
            }
        }
        return nums[i];
    }
}
