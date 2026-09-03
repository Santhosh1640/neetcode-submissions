class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->
            (a[0] * a[0] + a[1] * a[1])-(b[0] * b[0] + b[1] * b[1]));
        int[][] arr = new int[k][2];
        int n = points.length;
        for(int i=0; i<n; i++) {
            pq.offer(new int[]{points[i][0],points[i][1]});
        }

        int i=0;
        while(k>0) {
            arr[i] = pq.poll();
            k--;
            i++;   
        }
        return arr;

    }
}
