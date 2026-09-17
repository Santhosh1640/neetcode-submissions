class Solution {
    public void dfs(List<List<Integer>> adj, int node, boolean[] vis) {
        vis[node] = true;
        for(int num:adj.get(node)) {
            if(!vis[num]) {
                dfs(adj, num, vis);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected graph
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] vis = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                dfs(adj, i, vis);
                cnt++;
            }
        }
        return cnt;
    }
}
