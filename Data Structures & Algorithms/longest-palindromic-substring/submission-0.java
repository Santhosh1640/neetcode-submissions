class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        int startInd = 0;

        // length 1
        for(int i=0; i<n; i++) {
            dp[i][i] = true;
        }

        //length 2
        for(int i=0; i<n-1; i++) {
            if(s.charAt(i)==s.charAt(i+1)) {
                dp[i][i+1] = true;
                maxLen = 2;
                startInd = i;
            }
        }

        //length>=3

        for(int len=3; len<=n; len++) {
            for(int i=0; i<=n-len; i++) {
                int j = i+len-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;

                    if(len>maxLen) {    
                        maxLen = j-i+1;
                        startInd = i;
                    }
                }
            }
        }

        return s.substring(startInd, startInd+maxLen);


    }
}
