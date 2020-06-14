// Question : Largest Divisible Subset

// Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

// Si % Sj = 0 or Sj % Si = 0.

// If there are multiple solutions, return any subset is fine.

// Example 1:

// Input: [1,2,3]
// Output: [1,2] (of course, [1,3] will also be ok)
// Example 2:

// Input: [1,2,4,8]
// Output: [1,2,4,8]

//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;


//First Solution

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        List<Integer> result = new ArrayList();
        if(nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        int[][] dp = new int[nums.length][nums.length];
        int max=0;
        int index=0;
        
        int start = 0;
        if(nums[0] == 1){
            result.add(1);
            start=1;
        }
        
        int count =0;
        int index2=0;
        for(int i =start;i<nums.length;i++){
            count =0 ;
            index2= nums[i];
            for(int j =start;j<nums.length;j++){
               
                if(nums[i]%nums[j] == 0 || nums[j]%nums[i]==0 ){
                    if(index2%nums[j]==0 || nums[j]%index2==0){
                        dp[i][j] =1;
                        count++;
                        index2=nums[j];
                    }
                    
                }
            }
            if(count>max){
                max = count;
                index= i;
            }
            if(max>=nums.length-i){
                break;
            }
        }
           
         for(int i =0;i<nums.length;i++){
                if(dp[index][i] == 1){
                    result.add(nums[i]);
                }
            }
         
        
        return result;
    }
}

//Second Solution


class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] longest = new int[nums.length];
        int[] next = new int[nums.length];
        int start = Integer.MIN_VALUE, max = 0;
        
        Arrays.fill(next, -1);
        Arrays.sort(nums);
        
        for (int i = nums.length - 1; i >= 0; --i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (longest[j] > longest[i] && nums[j] % nums[i] == 0) {
                    longest[i] = longest[j];
                    next[i] = j;
                }
            }
            ++longest[i];
            if (longest[i] > max) {
                max = longest[i];
                start = i;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while (max-- > 0) {
            res.add(nums[start]);
            start = next[start];
        }
        return res;
    }
}