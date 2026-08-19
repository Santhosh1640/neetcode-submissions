class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int l = 0,r=n*m-1;
        while(l<=r) {
            int mid = (l+r)/2;
            int i = mid/m;
            int j = mid%m;


            if(target==matrix[i][j]) {
                return true;
            }
            else if(target<matrix[i][j]) {
                r=mid-1;
            }
            else {
                l=mid+1;
            }
        }
        return false;
    }
}
