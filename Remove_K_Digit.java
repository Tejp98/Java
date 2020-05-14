
// Question:   Remove K Digits

// Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

// Note:
// The length of num is less than 10002 and will be ≥ k.
// The given num does not contain any leading zero.
// Example 1:

// Input: num = "1432219", k = 3
// Output: "1219"
// Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
// Example 2:

// Input: num = "10200", k = 1
// Output: "200"
// Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
// Example 3:

// Input: num = "10", k = 2
// Output: "0"
// Explanation: Remove all the digits from the number and it is left with nothing which is 0.



//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;



class Solution {
    public String removeKdigits(String num, int k) {
         
         StringBuilder input = new StringBuilder(num);
        if(num.length() == k){

            return "0";
        }
        int index = 0;
        while(k>0){
            if(input.charAt(index) <= input.charAt(index+1)){
                index++;
            }
            else if(input.charAt(index) > input.charAt(index+1)){
                input.deleteCharAt(index);
                k--;
                if( index-1>=0){
                    index--;
                }
                else{
                    index = 0;
                }
                
            }
            
            if( k != 0 && index == input.length()-1){
                for( int b = 0;b<k ; b++){
                    input.deleteCharAt(index);
                    index--;
                }
                break;
            }
            
            
           
                
            while(input.charAt(0) == '0'){
                if(input.length() !=1){
                    input.deleteCharAt(0);   
                }
                else{
                    break;
                }
                        
            }
        
                    
        }
       return input.toString();
    }
}