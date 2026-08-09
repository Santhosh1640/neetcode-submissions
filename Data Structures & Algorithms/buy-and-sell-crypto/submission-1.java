class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = 0;
        int b = 0;
        int s = 1;

        while(s<n) {
            if(prices[b] < prices[s]) {
                ans = Math.max(ans, prices[s]-prices[b]);
            }
            else {
                b = s;
            }
            s++;
        }
        return ans;
    }
}
