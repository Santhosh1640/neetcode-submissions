class Solution {
    public void dfs(int ind, List<List<Integer>> adjList, boolean[] vis) {
        vis[ind] = true;
        for(int it: adjList.get(ind)) {
            if(!vis[it]) {
                dfs(it, adjList, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int r = isConnected.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<r; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        // [[1],[0],[]]

        for(int i=0; i<r; i++) {
            for(int j=0; j<r; j++) {
                if(isConnected[i][j]==1 && i!=j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        boolean[] vis = new boolean[r];
        int cnt = 0;

        for(int i=0; i<r; i++) {
            if(!vis[i]) {
                cnt++;
                dfs(i, adjList, vis);
            }
        }
        return cnt;
    }
}