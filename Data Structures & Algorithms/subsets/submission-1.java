class Solution {
    public void backtrack(int[] nums, int ind, List<Integer> sub, List<List<Integer>> list) {
        if(ind==nums.length) {
            list.add(new ArrayList<>(sub));
            return;
        }

        sub.add(nums[ind]);
        backtrack(nums, ind+1, sub, list);
        sub.remove(sub.size()-1);
        backtrack(nums, ind+1, sub, list);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), list);
        return list;
    }
}
