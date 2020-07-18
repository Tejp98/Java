//Question :  Two Sum

// Given an array of integers, return indices of the two numbers such that they add up to a specific target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// Example:

// Given nums = [2, 7, 11, 15], target = 9,

// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].



//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;

//First Solution

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        
        for(int i = 0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        
        return result;
        

}


//Second Solution

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] temporaryClone = nums.clone();
        
        Arrays.sort(nums);
        
        int start =0;
        int end = nums.length-1;
        int [] result = new int[2];
        while(start<end){
            int sum = nums[start] + nums[end];
            if(sum == target){
                result[0] = nums[start];
                result[1] = nums[end];
                break;
            }
            else if(sum>target){
                end--;
            }
            else{
                start++;
            }
        }
        
        int[] actualResult = new int[2];
        int index =0;
        for(int i = 0;i<nums.length;i++){
            if(temporaryClone[i] == result[1] || temporaryClone[i] == result[0]){
                
                actualResult[index] = i;
                index++;
            }
        }
       
        return actualResult;
    }
}