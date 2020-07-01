// Question : Arranging Coins

// You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

// Given n, find the total number of full staircase rows that can be formed.

// n is a non-negative integer and fits within the range of a 32-bit signed integer.

// Example 1:

// n = 5

// The coins can form the following rows:
// ¤
// ¤ ¤
// ¤ ¤

// Because the 3rd row is incomplete, we return 2.
// Example 2:

// n = 8

// The coins can form the following rows:
// ¤
// ¤ ¤
// ¤ ¤ ¤
// ¤ ¤

// Because the 4th row is incomplete, we return 3.


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;


//First Solution


class Solution {
    public int arrangeCoins(int n) {
        
        
        int start =1;
        while(n >= start){
            n -= start;
            start++;
            
        }
        return start-1;
    }
}


//Second Solution

class Solution {
  public int arrangeCoins(int n) {
    return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);
  }
}