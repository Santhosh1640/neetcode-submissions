class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums.length;
        int[] ans = new int[k];
        for(int i=0; i<n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((a,b) -> b.getValue() - a.getValue());

        for(int i=0; i<k; i++) {
            ans[i] = entries.get(i).getKey();
        }
        return ans;
    }
}
