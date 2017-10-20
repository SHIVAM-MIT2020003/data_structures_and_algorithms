package best_time_to_buy_and_sell_stock_III;

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices == null)
            return 0;

        int[][] dp = new int[3][prices.length];
        for(int i = 0; i < dp[0].length; i++)
            dp[0][i] = 0;

        for(int i = 0; i < dp.length; i++)
            dp[i][0] = 0;

        for(int i = 1; i <= 2; i++){
            for(int j = 1; j < prices.length; j++){
                int max = 0;
                if(prices[j] != 0)
                    for(int k = 0; k < j; k++){
                        max = Math.max(max, prices[j] - prices[k] + dp[i - 1][k]);
                    }
                dp[i][j] = Math.max(max, dp[i][j - 1]);
            }
        }
        return dp[2][dp[0].length - 1];
    }
}
