// Question : Student Attendance Record I


// You are given a string representing an attendance record for a student. The record only contains the following three characters:
// 'A' : Absent.
// 'L' : Late.
// 'P' : Present.
// A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).


// You need to return whether the student could be rewarded according to his attendance record.

// Example 1:
// Input: "PPALLP"
// Output: True
// Example 2:
// Input: "PPALLL"
// Output: False


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;



class Solution {
    public boolean checkRecord(String s) {
        int countA =0;
        int countL =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'A'){
                countA++;
                if(countA>1){
                    return false;
                }
            }
            if(s.charAt(i) == 'L' ){
                countL++;
                if(countL>=3){
                    return false;
                }
               
            }
            else{
                countL =0;
            }
        }
        
        return true;
    }
}