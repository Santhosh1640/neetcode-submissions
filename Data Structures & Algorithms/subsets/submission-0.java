class Solution {
    public void helper(int[] nums, int ind, int n, List<Integer> sub,
    List<List<Integer>> list) {
        if(ind>=n) {
            list.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[ind]);
        helper(nums, ind+1, n, sub, list);
        sub.remove(sub.size()-1);
        helper(nums, ind+1, n, sub, list);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(nums, 0, nums.length, new ArrayList<>(), list);
        return list;
    }
}
