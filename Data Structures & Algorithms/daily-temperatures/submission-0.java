class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        st.push(0);

        for(int i=1; i<n; i++) {
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]) {
                int ind = st.pop();
                ans[ind] = i-ind;
            }
            st.push(i);
        }
        return ans;
    }
}
