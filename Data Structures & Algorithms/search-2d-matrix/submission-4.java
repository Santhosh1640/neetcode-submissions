class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        int j = m*n-1;

        while(i<=j) {
            int mid = (i+j)/2;
            int num = matrix[mid/n][mid%n];
            if(num == target) {
                return true;
            }
            else if(num > target) {
                j = mid - 1;
            }
            else {
                i = mid + 1;
            }
        }
        return false;
    }
}
