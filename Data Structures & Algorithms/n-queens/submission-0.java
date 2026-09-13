class Solution {

    public boolean isSafe(char[][] board, int row, int col) {

        // upper-left diagonal
        int r = row - 1;
        int c = col - 1;

        while(r >= 0 && c >= 0) {
            if(board[r][c] == 'Q') return false;
            r--;
            c--;
        }

        // left
        c = col - 1;

        while(c >= 0) {
            if(board[row][c] == 'Q') return false;
            c--;
        }

        // lower-left diagonal
        r = row + 1;
        c = col - 1;

        while(r < board.length && c >= 0) {
            if(board[r][c] == 'Q') return false;
            r++;
            c--;
        }

        return true;
    }

    public void backtrack(char[][] board, int col,
                           List<List<String>> list, int n) {

        if(col == n) {
            List<String> solution = new ArrayList<>();

            for(char[] r : board) {
                solution.add(new String(r));
            }

            list.add(solution);
            return;
        }

        for(int row = 0; row < n; row++) {

            if(isSafe(board, row, col)) {

                board[row][col] = 'Q';       // choose

                backtrack(board, col + 1, list, n);  // recurse

                board[row][col] = '.';       // undo
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> list = new ArrayList<>();

        char[][] board = new char[n][n];

        for(char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(board, 0, list, n);

        return list;
    }
}