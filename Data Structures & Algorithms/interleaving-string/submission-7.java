
class Solution {

    public boolean helper(int i, int j, int n1, int n2,
                          String s1, String s2, String s3,
                          Boolean[][] dp) {

        if (i == n1 && j == n2) {
            return true;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean first = false;
        boolean second = false;

        if (i < n1 && s1.charAt(i) == s3.charAt(i + j)) {
            first = helper(i + 1, j, n1, n2, s1, s2, s3, dp);
        }

        if (j < n2 && s2.charAt(j) == s3.charAt(i + j)) {
            second = helper(i, j + 1, n1, n2, s1, s2, s3, dp);
        }

        return dp[i][j] = first || second;
    }

    public boolean isInterleave(String s1, String s2, String s3) {

        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 + n2 != s3.length()) {
            return false;
        }

        Boolean[][] dp = new Boolean[n1 + 1][n2 + 1];

        return helper(0, 0, n1, n2, s1, s2, s3, dp);
    }
}
