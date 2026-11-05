class Solution {
    public int helper(int[] coins, int ind, int n, int amount, int[][] dp) {
        if(amount==0) {
            return 1;
        }

        if(ind==coins.length) {
            return 0;
        }

        if(dp[ind][amount]!=-1) {
            return dp[ind][amount];
        }

        int pick = 0;
        if(amount>=coins[ind]) {
            pick = helper(coins, ind, n, amount-coins[ind], dp);
        }
        int notPick = helper(coins, ind+1, n, amount, dp);
        

        return dp[ind][amount] = pick+notPick;

        
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for(int[] row:dp) {
            Arrays.fill(row,-1);
        }
        return helper(coins, 0, n, amount, dp);
    }
}
