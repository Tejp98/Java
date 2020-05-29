// Question - Counting Bits

// Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

// Example 1:

// Input: 2
// Output: [0,1,1]
// Example 2:

// Input: 5
// Output: [0,1,1,2,1,2]
// Follow up:

// It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
// Space complexity should be O(n).
// Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;



class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
         if(num==0){
            return new int[]{0};
            
        }
        else if(num==1){
            return new int[]{0,1};
        }
        result[0]=0;
        result[1]=1;
        int value =4;
        
        
        
        for(int i =2;i<num+1;i++){
            if(i<value){
                
                if(i%2 == 0){
                    result[i] = 1+result[i-(value/2)];
                }
                else{
                    result[i] = result[i-1]+1;
                }
            }
            else{
                value = value*2;
                result[i] = 1;
            }
           
        }
       return result; 
    }
   
}