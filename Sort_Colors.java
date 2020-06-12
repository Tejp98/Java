
// Question :  Sort Colors

// Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

// Note: You are not suppose to use the library's sort function for this problem.

// Example:

// Input: [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
// Follow up:

// A rather straight forward solution is a two-pass algorithm using counting sort.
// First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
// Could you come up with a one-pass algorithm using only constant space?


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;

// First Solution


class Solution {
    public void sortColors(int[] nums) {
       int start =0;
        int end = nums.length-1;
        int current =0;
        
        while(current<nums.length && current<=end){
            if(nums[current] == 0){
                
                nums[current] = nums[start];
                nums[start] =0;
                start++;
                 current++;
            }
            else if(nums[current] == 2){
                
                nums[current] = nums[end];
                nums[end] =2;
                end--;
                
            }
            else{
                current++;
            }
            // for(int i=0;i<nums.length;i++){
            //     System.out.println(nums[i]);
            // }
            // System.out.println("new");
            
        }
    }
}





// Second Solution






class Solution {
    public void sortColors(int[] nums) {
        int index0=0,index2=0,index1=0;
        for(int i =0;i<nums.length;i++){
            if(nums[i] == 0){
                index0++;
            }
            else if(nums[i]==1){
                index1++;
            }
            else{
                index2++;
            }
        }
        for(int i = 0; i<index0;i++){
            nums[i] = 0;
        }
        for(int i = index0; i<index1+index0;i++){
            nums[i] = 1;
        }
        for(int i = index0+index1; i<nums.length;i++){
            nums[i] = 2;
        }
        
    }
}