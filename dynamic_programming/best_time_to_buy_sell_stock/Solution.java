package best_time_to_buy_sell_stock;

public class Solution {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int res = new Solution().maxProfit(prices);
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else if(maxProfit < prices[i] - minPrice){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}