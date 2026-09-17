class Solution {
    public boolean hasCycle(List<List<Integer>> adj, int node, int parent, boolean[] vis) {
        vis[node] = true;

        for(int neighbour:adj.get(node)) {
            if(!vis[neighbour]) {
                if(hasCycle(adj, neighbour, node, vis)) {
                    return true;
                }
            }else if(neighbour!=parent) {
                return true;
            }
        }
        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] vis = new boolean[n];

        //Check cycle
        if(hasCycle(adj, 0, -1, vis)) {
            return false;
        }

        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                return false;
            }
        }

        return true;
    }
}
