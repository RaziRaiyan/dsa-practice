package PracticeArrays.Medium;

// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

// Intuition:
// We can use a greedy approach to solve this problem.
// We can keep track of the minimum price and the maximum profit.
// We can iterate through the array and update the minimum price and the maximum profit.
// We can return the maximum profit.

public class StockBuyAndSell {
    public static void main(String[] args) {  
        int[] prices = {7,1,5,3,6,4};
        StockBuyAndSell sbs = new StockBuyAndSell();
        System.out.println(sbs.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }

        int max_profit = 0;
        int min_price = prices[0];

        for(int i=1; i<prices.length; i++){
            if(prices[i] - min_price > max_profit){
                max_profit = (prices[i] - min_price);
            }
            if(min_price > prices[i]){
                min_price = prices[i];
            }
        }

        return max_profit;
    }
}