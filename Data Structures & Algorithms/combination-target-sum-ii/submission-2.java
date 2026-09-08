class Solution {
    public void backtrack(int[] arr, int ind, int target, List<Integer> sub, List<List<Integer>> list) {
        if(target==0) {
            list.add(new ArrayList<>(sub));
            return;
        }

        for(int i=ind; i<arr.length; i++) {
            if(arr[i]>target) {
                break;
            }

            //handle duplicates
            if(i>ind && arr[i]==arr[i-1]) {
                continue;
            }

            //if(target>=arr[i]) {
                sub.add(arr[i]);
                backtrack(arr, i+1, target-arr[i], sub, list);
                sub.remove(sub.size()-1);

            
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>(), list);
        return list;
    }
}
