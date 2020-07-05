// Question : Hamming Distance


// The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

// Given two integers x and y, calculate the Hamming distance.

// Note:
// 0 ≤ x, y < 231.

// Example:

// Input: x = 1, y = 4

// Output: 2

// Explanation:
// 1   (0 0 0 1)
// 4   (0 1 0 0)
//        ↑   ↑

// The above arrows point to positions where the corresponding bits are different.

//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;


//First Solution

class Solution {
    public int hammingDistance(int x, int y) {
        if(x==y){
            return 0;
        }
         String one = Integer.toBinaryString(x);
        
        String two = Integer.toBinaryString(y);
        
        int result =0;
        
        int index1 = one.length()-1;
        int index2 = two.length()-1;
        
        
        while(index1 >=0 && index2 >= 0){
            if(one.charAt(index1) != two.charAt(index2)){
                result++;
            } 
            index1--;
            index2--;
        }
        
        if(x>y){
            for(int i =0;i<=index1;i++){
                if(one.charAt(i) == '1'){
                    result++;
                }
            }
        }
        else{
            for(int i =0;i<=index2;i++){
                if(two.charAt(i) == '1'){
                    result++;
                               
                }
            }
        }
        return result;
        
    }
}

//Second Solution

class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        if(x == y) {
            return count;
        }
        while(x != 0 && y !=0) {
            int xbit = (1 & x);
            int ybit = (1 & y); 
            if(xbit != ybit) {
                count++;
            }
            x = x >> 1;
            y = y >> 1;       
        }
        while(x != 0) {
            int xbit = (1 & x);
            if(xbit != 0) {
                count++;
            }
             x = x >> 1;
        }
         while(y != 0) {
            int ybit = (1 & y);
            if(ybit != 0) {
                count++;
            }
             y = y >> 1;
        } 
        
        return count;
        
    }
}