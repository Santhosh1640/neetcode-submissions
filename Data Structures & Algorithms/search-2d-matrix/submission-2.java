class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int i = 0;
        int j = m*n-1; //[[1,2]]

        // while(i<j) {
        //     int mid = (i+j)/2;
        //     arr[5] = arr[mid/n][mid/n];
        // }

        //matrix=[[1,3]], t=3

        while(i<=j) {
            int mid = (i+j)/2;
            int im = mid/m;
            int jm = mid%m;
            if(matrix[im][jm]==target) {
                return true;
            }
            else if(matrix[im][jm]<target) {
                i = mid+1;
            }
            else {
                j = mid-1;
            }
            
        }
        return false;
    }
}
