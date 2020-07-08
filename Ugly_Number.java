// Question : Ugly Number

// Write a program to check whether a given number is an ugly number.

// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

// Example 1:

// Input: 6
// Output: true
// Explanation: 6 = 2 × 3
// Example 2:

// Input: 8
// Output: true
// Explanation: 8 = 2 × 2 × 2
// Example 3:

// Input: 14
// Output: false 
// Explanation: 14 is not ugly since it includes another prime factor 7.
// Note:

// 1 is typically treated as an ugly number.
// Input is within the 32-bit signed integer range: [−231,  231 − 1].


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
    public boolean isUgly(int num) {
        if(num==0){
            return false;
        }
        return checkPrime(num);
    }
    public boolean checkPrime(int n){
        if(n==1){
            return true;
        }
        
        if(n %2 == 0){
           
            return  checkPrime((int)(n/2));
        }
        else if(n %3 == 0){
           
            
            return checkPrime((int)(n/3));
        }
        else if(n %5 == 0){
           
            
            return checkPrime((int)(n/5));
        }
        
        return false;
    }
}