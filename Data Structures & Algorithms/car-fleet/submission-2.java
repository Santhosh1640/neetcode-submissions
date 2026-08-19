class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        HashSet<Integer> set = new HashSet<Integer>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i < n; i++){
            pq.offer(new int[]{position[i], speed[i]});
        }
        double lastTime = 0;
        int fleets = 0;
        for(int i = 0; i < n; i++){
            int[] arr = pq.poll();
            int pos = arr[0];
            int spd = arr[1];
            
            double time = (double)(target - pos)/spd;
            if(time > lastTime) {
                fleets++;
                lastTime = time;
            }
        }

        return fleets;
    }
}
