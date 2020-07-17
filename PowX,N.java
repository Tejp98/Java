// Question : Pow(x,n)

// Implement pow(x, n), which calculates x raised to the power n (xn).

// Example 1:

// Input: 2.00000, 10
// Output: 1024.00000
// Example 2:

// Input: 2.10000, 3
// Output: 9.26100
// Example 3:

// Input: 2.00000, -2
// Output: 0.25000
// Explanation: 2-2 = 1/22 = 1/4 = 0.25
// Note:

// -100.0 < x < 100.0
// n is a 32-bit signed integer, within the range [−231, 231 − 1]


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
    public double myPow(double x, int n) {
        
        if(x == 1  || n == 0){
            return 1;
        }
        
        if(n ==1){
            return x;
        }
        
        if(n<0){
            // System.out.println(helper(x,n));
            // System.out.println(helper(x,(-1*n)));
            
            return (double)1.00000/(double)helper(x,(-1*n));
        }
        
        return helper(x,n);
        
       
    }
    
    public double helper(double x, int n){
        
        if(n ==0){
            return 1.00000;
        }
        
        if(n==1 || n == -1){
           return  (double)(x);
        }
        
       
        if(n % 2 == 0){
           
            double result = helper(x,n/2);
            return result*result;
        }
        else{
             double result = helper(x, (n-1)/2);
            
            return result*result*x;
        }
    
       
    }
}