class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];

        //left smaller
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && heights[i]<=heights[st.peek()]) {
                st.pop();
            }
            if(st.isEmpty()) {
                left[i] = -1;
            }
            else {
                left[i] = st.peek();
            }
            st.push(i);
        }

        //clear the stack
        while(!st.isEmpty()) {
            st.pop();
        }

        //right smaller
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && heights[i]<=heights[st.peek()]) {
                st.pop();
            }
            if(st.isEmpty()) {
                right[i] = n;
            }
            else {
                right[i] = st.peek();
            }
            st.push(i);
        }

        int maxx = 0;
        for(int i=0; i<n; i++) {
            maxx = Math.max(maxx, (right[i]-left[i]-1)*heights[i]);
        }
        return maxx;

    }
}
