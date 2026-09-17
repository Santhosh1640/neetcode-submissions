class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        int[] ans = new int[numCourses];
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];

        for(int i=0; i<n; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            adj.get(b).add(a);
            inDegree[a]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(inDegree[i]==0) q.add(i);
        }

        int ind = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            ans[ind] = node;
            for(int num:adj.get(node)) {
                inDegree[num]--;
                if(inDegree[num]==0) {
                    q.add(num);
                }
            }
            ind++;
        }

        if(ind!=numCourses) {
            return new int[0];
        }

        return ans;
    }
}
