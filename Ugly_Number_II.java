// Question : Ugly Number II


// Write a program to find the n-th ugly number.

// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

// Example:

// Input: n = 10
// Output: 12
// Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
// Note:  

// 1 is typically treated as an ugly number.
// n does not exceed 1690.


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;



//First Solution

class Solution {
    public int nthUglyNumber(int n) {
        
        if(n <=1 )
            return n;
        
        int t1=0;
        int t2=0;
        int t3=0;
        
        int []k = new int[n];
        k[0]=1;
        for(int i = 1 ; i < n ; i++){
            
            k[i] = Math.min(k[t1]*2,Math.min(k[t2]*3,k[t3]*5));
            if(k[i] == k[t1]*2) t1++;
            if(k[i] == k[t2]*3) t2++;
            if(k[i] == k[t3]*5) t3++;
        }
        
        return k[n-1];
        
    }
}



//Second Solution

// Naive Approach
class Solution {
    Map<Integer, Boolean> check = new HashMap<Integer, Boolean>();
    public int nthUglyNumber(int n) {
        // int[] two = new int[(int)(n/2)];
        // int[] three = new int[(int)(n/2)];
        // int[] five = new int[(int)(n/2)];
        check.put(1,true);
        int index = 2;
        int result =0;
        while(result < n-1){
            if(checkPrime(index)){
                check.put((index*2),true);
                check.put((index*3),true);
                check.put((index*5),true);
                result++;
            }
            index++;
        }
        return index-1;
    
    }
    
    public boolean checkPrime(int n){
        
        if(check.containsKey(n)){
            return check.get(n);
        }
        
        if(n %2 == 0){
            boolean result = checkPrime((int)(n/2));
            check.put(n,result);
            return result;
        }
        else if(n %3 == 0){
            boolean result = checkPrime((int)(n/3));
            check.put(n,result);
            return result;
        }
        else if(n %5 == 0){
            boolean result = checkPrime((int)(n/5));
            check.put(n,result);
            return result;
        }
        
        return false;
        
    }
}