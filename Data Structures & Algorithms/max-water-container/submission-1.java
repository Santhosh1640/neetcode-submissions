class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int l = 0,r = n-1;
        int maxx = 0;

        while(l<r) {
            int minn = Math.min(heights[l],heights[r]);
            maxx = Math.max(maxx, (r-l)*minn);
            if(heights[l]<=heights[r]) {
                l++;
            }
            else {
                r--;
            }
        }
        return maxx;
    }
}
