class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        // Left + Right borders
        for(int i = 0; i < n; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, m - 1);
        }

        // Top + Bottom borders
        for(int j = 0; j < m; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, n - 1, j);
        }

        List<List<Integer>> ans = new ArrayList<>();

        // Cells that can reach BOTH oceans
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }


    private void dfs(int[][] heights, boolean[][] visited, int r, int c) {

        if(visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        int[] dr = {0, -1, 0, 1};
        int[] dc = {-1, 0, 1, 0};

        for(int i = 0; i < 4; i++) {

            int nr = r + dr[i];
            int nc = c + dc[i];

            // Inside grid + reverse flow condition
            if(nr >= 0 && nr < heights.length &&
               nc >= 0 && nc < heights[0].length &&
               !visited[nr][nc] &&
               heights[nr][nc] >= heights[r][c]) {

                dfs(heights, visited, nr, nc);
            }
        }
    }
}