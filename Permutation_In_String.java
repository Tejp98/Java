
// Question: Permutation in String

// Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 




// Example 1:

// Input: s1 = "ab" s2 = "eidbaooo"
// Output: True
// Explanation: s2 contains one permutation of s1 ("ba").
// Example 2:

// Input:s1= "ab" s2 = "eidboaoo"
// Output: False
 

// Note:

// The input strings only contain lower case letters.
// The length of both given strings is in range [1, 10,000].




//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;




class Solution {
    public boolean checkInclusion(String s1, String s2) {
       
            if(s1.length()>s2.length()){
                return false;
            }

        
        int[] character_count = new int[26];
        for(char c: s1.toCharArray()){
            character_count[c-'a']++;
        }
         boolean check = true;
        for(int i =0; i<s1.length();i++){
            character_count[s2.charAt(i)-'a']--;
        }
        for(int i = 0;i<26;i++){
                if(character_count[i] != 0){
                    check = false;
                    break;
                }
            }
            if(check == true){
                return true;
            }
        
        int start =1;
        while(start <= s2.length()-s1.length()){
            character_count[s2.charAt(start-1)-'a']++;
            character_count[s2.charAt(start+s1.length()-1)-'a']--;
            check = true;
            for(int i = 0;i<26;i++){
                if(character_count[i] != 0){
                    check = false;
                    break;
                }
            }
            if(check == true){
                return true;
            }
            start++;
        }
        
        return false;
        
          
    }
}