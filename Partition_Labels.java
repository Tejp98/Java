// Question : Partition Labels

// A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

 

// Example 1:

// Input: S = "ababcbacadefegdehijhklij"
// Output: [9,7,8]
// Explanation:
// The partition is "ababcbaca", "defegde", "hijhklij".
// This is a partition so that each letter appears in at most one part.
// A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 

// Note:

// S will have length in range [1, 500].
// S will consist of lowercase English letters ('a' to 'z') only.


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList();
        int index = 0;
        
        int[] array = new int[26];
        
        for(int i=0;i<S.length();i++){
            array[S.charAt(i) - 'a']++;
        }
        
        int start =-1;
        
        while(index<S.length()){
            array[S.charAt(index) - 'a']--;
            boolean check = true;
            for(int i=index;i>=0;i--){
                if(array[S.charAt(i) - 'a'] != 0){
                    check = false;
                    break;
                }
            }
            if(check){
                result.add((index-start));
                
                start = index;
                
            }
            index++;
        }
        return result;
    }
}