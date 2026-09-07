class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n-k+1];

        //first window max
        for(int i=0; i<k; i++) {
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        int ind = 0;

        for(int i=k; i<n; i++) {
            ans[ind++] = nums[dq.peek()];
            while(!dq.isEmpty() && dq.peek()<i-k+1) {
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        ans[ind] = nums[dq.peek()];

        return ans;
    }
}
