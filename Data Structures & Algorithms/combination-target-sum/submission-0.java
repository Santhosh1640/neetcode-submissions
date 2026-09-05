class Solution {
    public void helper(int[] nums, int ind, int target, List<Integer> sub, List<List<Integer>> list) {
        if(ind==nums.length) {
          if(target==0) {
              list.add(new ArrayList<>(sub));
             
          }
          return;
        }
        sub.add(nums[ind]);
        if(target>=nums[ind]) {
            helper(nums, ind, target-nums[ind], sub, list);
        }
        sub.remove(sub.size()-1);
        helper(nums, ind+1, target, sub, list);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        helper(nums, 0, target, new ArrayList<>(), list);
        return list;
    }
}
