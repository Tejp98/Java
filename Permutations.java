// Question : Permutations


// Given a collection of distinct integers, return all possible permutations.

// Example:

// Input: [1,2,3]
// Output:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;



class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList();
        for(int i =0;i<nums.length;i++){
            list.add(nums[i]);
        }
        
        return permutations(list);
    }
    public List<List<Integer>> permutations(List<Integer> numbers){
        
        if(numbers.size() == 1){
            List<List<Integer>> result = new ArrayList();
            List<Integer> tem = new ArrayList();
            tem.add(numbers.get(0));
            result.add(tem);
            return result;
        
        }
        List<List<Integer>> result = new ArrayList();
        
        int end = numbers.size();
        int i =0;
        while(i<end){
            
            Integer temporary = numbers.get(0);
            
            numbers.remove(temporary);
             // List<List<Integer>> less =permutations(numbers);
            
            for(List<Integer> x : permutations(numbers)){
                List<Integer> local = new ArrayList();
                local.add(temporary);
                local.addAll(x);
                result.add(local);
            }
            numbers.add(temporary);
            
            i++;
        }
        return result;
    }
}