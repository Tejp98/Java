// Question : Unique Binary Search Trees


// Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

// Example:

// Input: 3
// Output: 5
// Explanation:
// Given n = 3, there are a total of 5 unique BST's:

//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3



   //  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
    
    public int numTrees(int n) {
        // if(n==1){
        //     return 1;
        // }
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        // dp[2] =2;
        int total =0;
       for(int i= 2;i<=n;i++){
           int middle = i%2==0 ? i/2 : ((i-1)/2);
           
           for(int j=1;j<=middle;j++){
               total = total + (2*dp[j-1]*dp[i-j]);
              
           }
           
           if(i%2!=0){
               
               int middle1 = ((i+1)/2);
               
               total = total + (dp[middle1-1]*dp[i-middle1]);
           }
           
           dp[i] = total;
           total =0;
            
       }
            
        return dp[n];
    }
   
}