// Question : Single Number

// Given a non-empty array of integers, every element appears twice except for one. Find that single one.

// Note:

// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

// Example 1:

// Input: [2,2,1]
// Output: 1
// Example 2:

// Input: [4,1,2,1,2]
// Output: 4


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;

// First Solution

class Solution {
    public int singleNumber(int[] nums) {
       
        
        for(int i =0;i<nums.length-1;i++){
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
            i++;
        }
        return nums[nums.length-1];
        
    }
}

// Second Solution
    class Solution {
    public int singleNumber(int[] nums) {
        
        Arrays.sort(nums);
       
        return recursion(nums, 0, nums.length-1);
       
        
        
    }
    public int recursion(int[] nums, int left, int right){
       if((right-left)<=0){ 
        if(left==right-2){
            if(nums[left] == nums[left+1]){
                return nums[left+2];
            }
            else{
                return nums[left];
            }
        }
        else if(left == right-1){
            if(nums[left]==nums[left-1]){
                return nums[left+1];
            }
            else{
                return nums[left];
            }
        }
        else if(left==right){
            return nums[left];
        }
       }
        
        
        int middle =(int)(left+right)/2;
       
        if(nums[middle] == nums[middle-1]){
            
            if(((middle-1)-left)%2==0){
                
                return recursion(nums,middle+1,right);
            }
            
            return recursion(nums, left, middle-2 );
        }
        else if(nums[middle] == nums[middle+1]){
            if(((middle-2)-left)%2==0){
                return recursion(nums, middle+2, right); 
            }
           return recursion(nums,left, middle-1);
        }
        
        return nums[middle];
    }
}