// Question : Permutation Sequence


// The set [1,2,3,...,n] contains a total of n! unique permutations.

// By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.

// Note:

// Given n will be between 1 and 9 inclusive.
// Given k will be between 1 and n! inclusive.
// Example 1:

// Input: n = 3, k = 3
// Output: "213"
// Example 2:

// Input: n = 4, k = 9
// Output: "2314"

//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public String getPermutation(int n, int k) {
        
        if(n==1){
            return "1";
        }
        
        List<Integer> all_numbers = new ArrayList();
        int[] permutation = new int[n-1];
        permutation[0] = 1;
        for(int i=1;i<permutation.length;i++){
            permutation[i] = permutation[i-1]*(i+1);
        }
        for(int i=0;i<n;i++){
            all_numbers.add(i+1);
        }
        
        String result ="";
        boolean check = false;
        for(int i = n-1; i>0;i--){
            int temporary = k%permutation[i-1]==0 ? k/permutation[i-1]-1 : (int)(k/permutation[i-1]);
            result = result + all_numbers.get(temporary);
            
            all_numbers.remove(temporary);
    
            k = k % permutation[i-1];
            if(k<=0){
                check = true;
                break;
            }
            if(all_numbers.size()==1){
                result += all_numbers.get(0);
                break;
            }
        }
        
        if(check){
            if(k<0){
                for(int j=0;j<all_numbers.size();j++){
                    result =result + all_numbers.get(j);
                }
                
            }
            else if(k==0){
                for(int j=all_numbers.size()-1;j>=0;j--){
                    result =result + all_numbers.get(j);
                }
                
            }
        }
        
    
        return result;
    }
}