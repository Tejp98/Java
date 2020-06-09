// Question : Power of Two


// Given an integer, write a function to determine if it is a power of two.

// Example 1:

// Input: 1
// Output: true 
// Explanation: 20 = 1
// Example 2:

// Input: 16
// Output: true
// Explanation: 24 = 16
// Example 3:

// Input: 218
// Output: false

//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;



class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==1){
            return true;
        }
        else if(n<=0){
            return false;
        }
        
        
        while(n >1){
            if(n%2==0){
                n = (int)n/2;
            }
            else{
                return false;
            }
        }
        return true;
    }
}