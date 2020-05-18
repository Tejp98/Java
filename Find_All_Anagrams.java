// Question : Find All Anagrams in a String

// Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

// Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

// The order of output does not matter.

// Example 1:

// Input:
// s: "cbaebabacd" p: "abc"

// Output:
// [0, 6]

// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".
// Example 2:

// Input:
// s: "abab" p: "ab"

// Output:
// [0, 1, 2]

// Explanation:
// The substring with start index = 0 is "ab", which is an anagram of "ab".
// The substring with start index = 1 is "ba", which is an anagram of "ab".
// The substring with start index = 2 is "ab", which is an anagram of "ab".




//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;





class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        
        if(s == null || s.length()==0 || p.length()>s.length()){
            return result;
        }
        int[] pchar = new int[26];
        for(char c : p.toCharArray()){
            pchar[c - 'a']++;
        }
        
        for(int i =0;i<p.length();i++){
            pchar[s.charAt(i)-'a']--;
            
        
        }
        boolean count = true;
        
         for(int i=0 ;i<26;i++){
             if(pchar[i] != 0){
                 count = false;
                 break;
             }
         }
        if(count==true){
            result.add(0);
        }
        
        
        int start = 1;
        while(start <= s.length()-p.length()){
            
            pchar[s.charAt(start-1)-'a']++;
            
            
            
            pchar[s.charAt(start+p.length()-1)-'a']--;
            count = true;
             for(int i =0;i<26;i++){
                 if(pchar[i]!=0){
                     count = false;
                     break;
                 }
                
             }
            if(count == true){
                result.add(start);
            }
           
            start++;
        }
        
        
          
        return result;
    }
}