class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==2) {
                    vis[i][j] = true;
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[] r = {0,-1,0,1};
        int[] c = {-1,0,1,0};

        int cnt = 0;

        while(!q.isEmpty() && fresh>0) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] arr = q.poll();
                for(int j=0; j<4; j++) {
                    int row = arr[0]+r[j];
                    int col = arr[1]+c[j];

                    if(row>=0 && row<n && col>=0 && col<m && grid[row][col]==1 && !vis[row][col]) {
                        vis[row][col] = true;
                        grid[row][col] = 2;
                        fresh--;
                        q.add(new int[]{row,col});
                    }
                }
            }
            cnt++;
        }

        return fresh==0?cnt:-1;
    }
}
