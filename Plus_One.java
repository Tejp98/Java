// Question : Plus One


// Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

// The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

// You may assume the integer does not contain any leading zero, except the number 0 itself.

// Example 1:

// Input: [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.
// Example 2:

// Input: [4,3,2,1]
// Output: [4,3,2,2]
// Explanation: The array represents the integer 4321.

//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
    public int[] plusOne(int[] digits) {
        int carry =1;
        int index=digits.length-1;
        while( index >= 0){
            int temporary = (digits[index]+carry);
            carry = (int)temporary/10;
            digits[index] = temporary%10;
            if(carry == 0){
                return digits;
            }
            index--;
        }
        int[] result = new int[digits.length+1];
        if(carry != 0){
            result[0] = carry;
            for(int i =0;i<digits.length;i++){
                result[i+1] = digits[i];
            }
        }
        return result;
    }
}