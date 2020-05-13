
//Question:  Single Element in a Sorted Array


// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

 

// Example 1:

// Input: [1,1,2,3,3,4,4,8,8]
// Output: 2
// Example 2:

// Input: [3,3,7,7,10,11,11]
// Output: 10



import java.util.*;
import java.lang.*;
import java.io.*;



class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int index =0;
        while(index<nums.length-1){
            if(nums[index]==nums[index+1]){
                index += 2;
                continue;
            }
            else{
                return nums[index];
            }
        }
        return nums[nums.length-1];
    }
}