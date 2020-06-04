// Question : Reverse String From Char Array

// Write a function that reverses a string. The input string is given as an array of characters char[].

// Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

// You may assume all the characters consist of printable ascii characters.

 

// Example 1:

// Input: ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]
// Example 2:

// Input: ["H","a","n","n","a","h"]
// Output: ["h","a","n","n","a","H"]


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;



class Solution {
    public void reverseString(char[] s) {
        int indexFront =0;
        int indexBack =s.length-1;
        
        while(indexFront<indexBack){
            char temporary = s[indexFront];
            s[indexFront] = s[indexBack];
            s[indexBack]= temporary;
            indexFront++;
            indexBack--;
        }
       
    }
}