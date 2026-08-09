class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[][] a = new int[n][2];
        for(int i=0; i<n; i++) {
            a[i][0] = nums[i];
            a[i][1] = i;
        }
        Arrays.sort(a, Comparator.comparingInt(arr -> arr[0]));
        int i=0,j=n-1;
        while(i<j) {
            int curr = a[i][0]+a[j][0];
            if(curr == target) {
                return new int[]{Math.min(a[i][1],a[j][1]), Math.max(a[i][1],a[j][1])};
            }
            else if(curr < target) {
                i++;
            }
            else {
                j--;
            }
        }
        return new int[0];
    }
}
