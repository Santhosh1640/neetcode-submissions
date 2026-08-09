class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n; i++) {
            //Edge cases
            if(nums[i]>0) break;
            if(i>0 && nums[i]==nums[i-1]) continue;
            int l = i+1;
            int r = n-1;

            while(l<r) {
                List<Integer> list = new ArrayList<>();
                int sum = nums[i] + nums[l] + nums[r];
                
                if(sum==0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    // Handles duplicate values
                    while(l<r && nums[l] == nums[l-1]) {
                        l++;
                    }
                } 
                else if(sum < 0) {
                    l++;
                }
                else {
                    r--;
                }
            
            }
        }
        return ans;
    }
}
