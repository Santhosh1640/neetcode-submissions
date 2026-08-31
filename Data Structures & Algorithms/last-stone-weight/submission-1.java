class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int num:stones) {
            pq.offer(num);
        }

        while(!pq.isEmpty() && pq.size()>1) {
            int a = pq.poll();
            int b = pq.poll();
            if(a!=b) {
                pq.offer(Math.abs(a-b));
            }
        }
        return pq.size()==1?pq.poll():0;

    }
}

