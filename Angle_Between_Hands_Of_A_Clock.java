// Question : Angle Between Hands of a Clock

// Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.

 

// Example 1:



// Input: hour = 12, minutes = 30
// Output: 165
// Example 2:



// Input: hour = 3, minutes = 30
// Output: 75
// Example 3:



// Input: hour = 3, minutes = 15
// Output: 7.5
// Example 4:

// Input: hour = 4, minutes = 50
// Output: 155
// Example 5:

// Input: hour = 12, minutes = 0
// Output: 0
 

// Constraints:

// 1 <= hour <= 12
// 0 <= minutes <= 59
// Answers within 10^-5 of the actual value will be accepted as correct.



//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;






class Solution {
    public double angleClock(int hour, int minutes) {
        
        double hourPlusMinute = (double)(minutes*5)/60;
        // System.out.println(hourPlusMinute);
        double hourToMinute = (hour*5) + hourPlusMinute;
         // System.out.println(hourToMinute);
        double angle =( minutes- hourToMinute)*6;
        // System.out.println(angle);
        if(angle<0){
            angle = angle*-1;
        }
        
        if(angle>180){
            return 360-angle;
        }
    
        return angle;
        
    }
}