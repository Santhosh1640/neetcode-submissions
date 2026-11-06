class Solution {
    public int helper(int[] prices, int ind, int buy, int[][] dp) {
        if(ind>=prices.length) {
            return 0;
        }
        if(dp[ind][buy]!=-1) {
            return dp[ind][buy];
        }
        int profit;
        if(buy==1) {
            int buyStock = -prices[ind] + helper(prices, ind+1, 0, dp);
            int skip1 = helper(prices, ind+1, 1, dp);

            profit = Math.max(buyStock, skip1);

        }
        else {
            int sellStock = prices[ind] + helper(prices, ind+2, 1, dp);
            int skip2 = helper(prices, ind+1, 0, dp);

            profit = Math.max(sellStock, skip2);
        }

        return dp[ind][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(prices, 0, 1, dp);
    }
}
