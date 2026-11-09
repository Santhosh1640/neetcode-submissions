class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<m; j++) {
                //swap arr[i][j] with arr[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0; i<n; i++) {
            int j=0;
            while(j<m/2){
                //reverse each row
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m-j-1];
                matrix[i][m-j-1] = temp;
                j++;
            }
        }
    }
}
