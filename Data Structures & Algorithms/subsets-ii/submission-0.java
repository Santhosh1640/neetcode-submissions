class Solution {
    public void backtrack(int[] nums, int ind, List<Integer> sub, List<List<Integer>> list) {
        list.add(new ArrayList<>(sub));

        for(int i=ind; i<nums.length; i++) {
            if(i>ind && nums[i]==nums[i-1]) {
                continue;
            }
            sub.add(nums[i]);
            backtrack(nums, i+1, sub, list);
            sub.remove(sub.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), list);
        return list;

    }
}
