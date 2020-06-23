// Question : Best Time to Buy and Sell Stock


// Say you have an array for which the ith element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

// Note that you cannot sell a stock before you buy one.

// Example 1:

// Input: [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//              Not 7-1 = 6, as selling price needs to be larger than buying price.
// Example 2:

// Input: [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transaction is done, i.e. max profit = 0.


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;



// First Solution

class Solution {
    public int maxProfit(int[] prices) {
        // int[][] dp = new int[prices.length][prices.length];
        int result =0;
        int min =10000000;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]<prices[i+1] && prices[i]<min){
                
            
            for(int j=i+1;j<prices.length;j++){
                // dp[i][j] = prices[j]-prices[i];
                result = Math.max(result,prices[j]-prices[i]);
                min = prices[i];
            }
            }
        }
        return result;
    }
}
// Second Solution

public class Solution {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}