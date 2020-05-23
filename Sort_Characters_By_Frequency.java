




// Question: Sort Characters By Frequency

// Given a string, sort it in decreasing order based on the frequency of characters.

// Example 1:

// Input:
// "tree"

// Output:
// "eert"

// Explanation:
// 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
// Example 2:

// Input:
// "cccaaa"

// Output:
// "cccaaa"

// Explanation:
// Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
// Note that "cacaca" is incorrect, as the same characters must be together.
// Example 3:

// Input:
// "Aabb"

// Output:
// "bbAa"

// Explanation:
// "bbaA" is also a valid answer, but "Aabb" is incorrect.
// Note that 'A' and 'a' are treated as two different characters.






 //  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.

// Fast Solution:

import java.util.*;
import java.lang.*;
import java.io.*;



class Solution {
    public String frequencySort(String s) {
       int[] count = new int[92];
        int loop =0;
       for(char c : s.toCharArray()){
          if(count[c-' '] == 0){
               loop++;
           }
           count[c-' ']++;
           
       }
        String result = new String();
        
        int index =0;
        
        while(loop>=0){
             int max=0;
            for(int i=0;i<count.length;i++){
                if(count[i]>max){
                    max = count[i]; 
                    index= i;
                }
            }
            int value = index +' ';  
            count[index] = 0;
             char c = (char)value;
            
            result = result + Character.toString(c).repeat(max);
            loop--;
        }
         
        return result;
    }
}






// Slow Solution:

class Solution {
    public String frequencySort(String s) {
       
       
        char[] input =s.toCharArray();
        String both = new String();
        Arrays.sort(input);
        int index=0,count=1;
        while(index<input.length){
            if(index==input.length-1){
                if(input[index]==input[index-1]){
                    
                    both=both+input[index]+count;
                    break;
                }
                else{
                    if(count!=1){
                        both=both+input[index-1]+count+input[index]+"1";
                    }
                    else{
                        both=both+input[index]+count;
                    }
                    break;
                }
            }
            else if(input[index]==input[index+1]){
                count++;
            }
            else{
                both= both+input[index]+count;
                count=1;
            }
            
            index++;
        }
        
        ArrayList<Character> character = new ArrayList();
        ArrayList<Integer> number = new ArrayList();
        
       
        for(int i =0;i<both.length();i++){
            if(i%2==0){
                character.add(both.charAt(i));
            }
            else{
                number.add(Character.getNumericValue(both.charAt(i)));
            }
        }
        
        index=0;
        String result = new String();
        while(character.size()!=0){
          
            int max =0;
            for(int j=0;j<number.size();j++){
                if(number.get(j) >max){
                    max = number.get(j);
                    index=j;
                }
            }
           
            result = result + repeat(character.get(index), max);
            character.remove(index);
            
            number.remove(index);
        }
        return result;
    }
    public String repeat(char character, int times){
        String answer = new String();
        for(int i=0;i<times;i++){
            answer = answer+character;
        }
        return answer;
               
         
    }
}