
//  Question :  Cheapest Flights Within K Stops

// There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.

// Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

// Example 1:
// Input: 
// n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
// src = 0, dst = 2, k = 1
// Output: 200
// Explanation: 
// The graph looks like this:


// The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
// Example 2:
// Input: 
// n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
// src = 0, dst = 2, k = 0
// Output: 500
// Explanation: 
// The graph looks like this:


// The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 

// Constraints:

// The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
// The size of flights will be in range [0, n * (n - 1) / 2].
// The format of each flight will be (src, dst, price).
// The price of each flight will be in the range [1, 10000].
// k is in the range of [0, n - 1].
// There will not be any duplicated flights or self cycles.


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;



class Solution {
   
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        
        int[][]dp = new int[n][n];
       
        for(int i=0;i<flights.length;i++){
            dp[flights[i][0]][flights[i][1]] = flights[i][2];
        }
        
        
        return recursion(dp, src, dst, K);
        
        
        
        
        
    }
    public int recursion(int[][] dp, int src, int dst, int K){
       int min =10001;
        if(K<=0){
            if(dp[src][dst]>0){
                return dp[src][dst];
            }
            else{
                return -1;
            }
        }
        else{
            for(int i=0; i<dp.length;i++){
                if(dp[src][i]>0){
                    if(i==dst && min>dp[src][i]){
                        min = dp[src][i];
                    }
                    else{
                         int value= recursion(dp, i, dst, K-1);
                        if(value>0 && value+dp[src][i] < min){
                            min = value+dp[src][i];

                        }
                    }
                }
            }
        }
        
        if(min == 10001){
            return -1;
        }
        else{
            return min;
        }
    }
    
 
}