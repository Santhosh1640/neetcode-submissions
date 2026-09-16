class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDeg = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] arr:prerequisites) {
            inDeg[arr[0]]++;
            graph.get(arr[1]).add(arr[0]);
        }

        for(int i=0; i<numCourses; i++) {
            if(inDeg[i]==0) {
                q.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for(int num: graph.get(node)) {
                inDeg[num]--;
                if(inDeg[num]==0) {
                    q.add(num);
                }
            }
        }

        return ans.size()==numCourses;

    }
}
