class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int i=0,j=n-1;

        while(i<=j) {
            int mid = (i+j)/2;
            int num = nums[mid];
            if(num==target) {
                return mid;
            }
            if(nums[i] <= num) {
                if(target > num || target < nums[i]) {
                    i = mid+1;
                }
                else {
                    j = mid-1;
                }
            }
            else {
               if(target < num || target > nums[j]) {
                j = mid-1;
               }
               else {
                i=mid+1;
               }
            }
        }
        return -1;
    }
}
