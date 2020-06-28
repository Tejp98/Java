// Question : Perfect Squares


// Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

// Example 1:

// Input: n = 12
// Output: 3 
// Explanation: 12 = 4 + 4 + 4.
// Example 2:

// Input: n = 13
// Output: 2
// Explanation: 13 = 4 + 9.

//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;

//First Solution

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i =2;i<=n;i++){
            int min = i;
            int j =1;
            while((j*j)<=i){
                int square = j*j;
                min = Math.min(min, 1+dp[i-square]);
                j++;
            }
            dp[i] = min;
        }
        
        return dp[n];
    }
}


//Second Solution

class Solution {
    public int numSquares(int n) {
        int nearestSquare  = (int)(Math.sqrt(n));
        int i =2;
        int min = n;
         while(i<=nearestSquare){
            min = Math.min(min, helper(n,i));
             
             i++;
         }
        return min;
        
        
    }
    public int helper(int n, int current){
        int square = current*current;
        if(n % square == 0){
            return n/square;
        }
        int max = (int)(n/square);
        
        return max+numSquares(n-(max*square));
        
    }
}