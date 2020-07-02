// Question : Long Pressed Name

// Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

// You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.

 

// Example 1:

// Input: name = "alex", typed = "aaleex"
// Output: true
// Explanation: 'a' and 'e' in 'alex' were long pressed.
// Example 2:

// Input: name = "saeed", typed = "ssaaedd"
// Output: false
// Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
// Example 3:

// Input: name = "leelee", typed = "lleeelee"
// Output: true
// Example 4:

// Input: name = "laiden", typed = "laiden"
// Output: true
// Explanation: It's not necessary to long press any character.
 

// Constraints:

// 1 <= name.length <= 1000
// 1 <= typed.length <= 1000
// The characters of name and typed are lowercase letters.


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;



class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(name.length() > typed.length()){
            
            return false;
        }
        if(name.length() == typed.length() && name.equals(typed)){
            return true;
        }
        
        int indexName =0;
        int indexTyped =0;
        char previous = '0';
        while(indexName<name.length() && indexTyped<typed.length()){
            
            if(name.charAt(indexName) == typed.charAt(indexTyped)){
                indexTyped++;
                previous = name.charAt(indexName);
                indexName++;
                
            }
            else if(previous == typed.charAt(indexTyped)){
                        indexTyped++;
                    }
            else{
                  return false;
                }
                
               
            
            
        }
        while(indexTyped<typed.length()){
            if(previous == typed.charAt(indexTyped)){
                indexTyped++;
            }
            else{
                return false;
            }
        }
        if(indexName == name.length()){
            return true;
        }
        
        return false;
    }
}