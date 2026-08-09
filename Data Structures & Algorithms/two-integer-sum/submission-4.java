class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] arr = new int[2];


        for(int i=0; i<n; i++) {
            int sum = target-nums[i];
            if(map.containsKey(sum)) {
                arr[0] = map.get(sum);
                arr[1] = i;
                break;
            }
            else {
                map.put(nums[i],i);
            }

        }
        return arr;
    }
}
