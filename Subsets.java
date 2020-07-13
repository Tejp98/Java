// Question : Subsets
// Given a set of distinct integers, nums, return all possible subsets (the power set).

// Note: The solution set must not contain duplicate subsets.

// Example:

// Input: nums = [1,2,3]
// Output:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]



//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;

//First Solution


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        gensubset(0,nums,new ArrayList<>(),ans);
        return ans;
    }
    
    public void gensubset(int index, int[]nums, List<Integer> curr,List<List<Integer>> ans){
        ans.add(new ArrayList<>(curr));
        for(int i=index;i<nums.length;i++){
            curr.add(nums[i]);
            gensubset(i+1,nums,curr,ans);
            curr.remove(curr.size()-1);
        }
    }
}


//Second Solution



class Solution {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList();

    int n = nums.length;

    for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
     
      String bitmask = Integer.toBinaryString(i).substring(1);
      
      List<Integer> current = new ArrayList();
      for (int j = 0; j < n; ++j) {
        if (bitmask.charAt(j) == '1') {
        current.add(nums[j]);
        }
      }
      result.add(current);
    }
    return result;
  }
}