// LeetCode 121
// Best Time to Buy and Sell Stock
// Topic: Arrays
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int maxProfit(int[] prices){
        int min=prices[0];
        int maxProfit=0;

        for(int i=1;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }else{
                int profit=prices[i]-min;
                maxProfit=Math.max(maxProfit,profit);
            }
        }
        return maxProfit;
    }
}
