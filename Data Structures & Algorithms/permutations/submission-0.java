class Solution {
    public void backtrack(int[] nums, List<Integer> sub, List<List<Integer>> list, boolean[] vis) {
        if(sub.size()==nums.length) {
            list.add(new ArrayList<>(sub));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(!vis[i]) {
                sub.add(nums[i]);
                vis[i] = true;
                backtrack(nums, sub, list, vis);
                sub.remove(sub.size()-1);
                vis[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        Arrays.fill(vis, false);
        backtrack(nums, new ArrayList<>(), list, vis);
        return list;
    }
}
