class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        int ind = 0;

        for(int i=1; i<intervals.length; i++) {
            if(intervals[ind][1]>=intervals[i][0]) {
                intervals[ind][1] = Math.max(intervals[ind][1],intervals[i][1]);
            }
            else {
                ind++;
                intervals[ind] = intervals[i];
            }
        }

        return Arrays.copyOf(intervals, ind+1);
    }
}
