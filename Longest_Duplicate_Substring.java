// Question : Longest Duplicate Substring (Hard Question)


// Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.  (The occurrences may overlap.)

// Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring, the answer is "".)

 

// Example 1:

// Input: "banana"
// Output: "ana"
// Example 2:

// Input: "abcd"
// Output: ""
 

// Note:

// 2 <= S.length <= 10^5

// S consists of lowercase English letters.

//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;


//First Solution (Good Time Complexity)


class Solution {
public int search(int L, int a, long modulus, int n, int[] nums) {
  
  long h = 0;
  for(int i = 0; i < L; ++i) h = (h * a + nums[i]) % modulus;

  
  HashSet<Long> seen = new HashSet();
  seen.add(h);
  
  long aL = 1;
  for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;

  for(int start = 1; start < n - L + 1; ++start) {
    
    h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
    h = (h + nums[start + L - 1]) % modulus;
    if (seen.contains(h)) return start;
    seen.add(h);
  }
  return -1;
}

public String longestDupSubstring(String S) {
  int n = S.length();
  
  int[] nums = new int[n];
  for(int i = 0; i < n; ++i) nums[i] = (int)S.charAt(i) - (int)'a';
  
  int a = 26;
  
  long modulus = (long)Math.pow(2, 32);

  
  int left = 1, right = n;
  int L;
  while (left != right) {
    L = left + (right - left) / 2;
    if (search(L, a, modulus, n, nums) != -1) left = L + 1;
    else right = L;
  }

  int start = search(left - 1, a, modulus, n, nums);
  return start != -1 ? S.substring(start, start + left - 1) : "";
} 

}


// Second  Solution (Bad Time Complexity)

class Solution {
    public String longestDupSubstring(String S) {
        int[] character = new int[26];
        for( char x : S.toCharArray()){
            character[x - 'a']++;
        }
      
        
        
        for(int i = S.length()-1; i>0;i--){
            for(int j = 0;j<=S.length()-i;j++){
                    if(character[S.charAt(j)-'a']>1){
                        String temporary = S.substring(j, j+i);
                        for(int k = j+1; k<=S.length()-i;k++){
                            if(temporary.equals(S.substring(k,k+i))){
                                return temporary;
                            }
                        }
                    }
                
            }
        }
        return "";
}
}