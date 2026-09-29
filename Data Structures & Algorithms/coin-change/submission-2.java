class Solution {

    public int dfs(int[] coins, int amount, int[] dp) {

        // Found a valid combination
        if(amount == 0) {
            return 0;
        }

        // Invalid path
        if(amount < 0) {
            return Integer.MAX_VALUE;
        }

        if(dp[amount]!=-1) {
            return dp[amount];
        }

        int minn = Integer.MAX_VALUE;

        for(int coin : coins) {
            int result = dfs(coins, amount - coin, dp);
            if(result!=Integer.MAX_VALUE) {
                minn = Math.min(minn, result+1);
            }


        }
        return dp[amount] = minn;
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);

        int minn = dfs(coins, amount, dp);

        return minn == Integer.MAX_VALUE ? -1 : minn;
    }
}