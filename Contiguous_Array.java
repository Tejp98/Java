// Question : Contiguous Array

// Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

// Example 1:
// Input: [0,1]
// Output: 2
// Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
// Example 2:
// Input: [0,1,0]
// Output: 2
// Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
// Note: The length of the given binary array will not exceed 50,000.

//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
    public int findMaxLength(int[] nums) {
       HashMap <Integer,Integer> counts = new HashMap();
        counts.put(0, -1);
        int max_length = 0,count =0;
        for (int i =0 ; i<nums.length; i++) {
            if (nums[i] == 1){
                count += 1;
            } 
            else { 
                count += -1;    
            }

            if (counts.containsKey(count)) { 
                max_length = Math.max(max_length, i-counts.get(count));

            } 
            else {
                counts.put(count, i);
                 }

                }
                    
                    
        return max_length;      
        
    }
}