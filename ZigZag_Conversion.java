//  Question : ZigZag Conversion

// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"

// Write the code that will take a string and make this conversion given a number of rows:

// string convert(string s, int numRows);
// Example 1:

// Input: s = "PAYPALISHIRING", numRows = 3
// Output: "PAHNAPLSIIGYIR"
// Example 2:

// Input: s = "PAYPALISHIRING", numRows = 4
// Output: "PINALSIGYAHRPI"
// Explanation:

// P     I    N
// A   L S  I G
// Y A   H R
// P     I

//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
    public String convert(String s, int numRows) {
        
        if(s.length() <=1 || s.length() <= numRows){
            return s;
        }
        
        StringBuilder[] array = new StringBuilder[numRows];
       
        for(int i =0;i<numRows;i++){
            array[i] = new StringBuilder();
        }
        
         int index = 0;
        
        while(index<(s.length()-(numRows+(numRows-2)))){
            
            for(int i =0;i<numRows;i++){
                array[i].append(s.charAt(index));
                index++;
                
            }
            
            for(int i = numRows-2;i>0;i--){
                array[i].append(s.charAt(index));
                index++;
                
            }
            
            
    
        }
        if(index<s.length()){
        for(int i =0;i<numRows;i++){
                array[i].append(s.charAt(index));
                index++;
                if(index>=s.length()){
                    break;
                }
            }
        }
        if(index<s.length()){
            for(int i = numRows-2;i>0;i--){
                array[i].append(s.charAt(index));
                index++;
                if(index>=s.length()){
                    break;
                }
            } 
        }
           
        
        String result= "";
        for(StringBuilder x : array){
            result += x.toString();
        }
        return result;
    }
}