
import java.util.*;
import java.lang.*;





// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
// For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

// Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900.
// Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

// Example 1:

// Input: 3
// Output: "III"


// Solution one
class Solution {
    public String intToRoman(int num) {
        StringBuilder sb=new StringBuilder();
        while(num>=1000){
            sb.append("M");
            num=num-1000;
    
        }
        while(num>=500){
            if(num>=900){
                sb.append("CM");
                num=num-900;
            }else{
            sb.append("D");
            num=num-500;
            }
        }
        while(num>=100){
            if(num>=400){
                sb.append("CD");
                num=num-400;
            }else{
            sb.append("C");
            num=num-100;
            }
        }
        while(num>=50){
            if(num>=90){
                sb.append("XC");
                num=num-90;
            }else{
            sb.append("L");
            num=num-50;
            }
        }
        while(num>=10){
            if(num>=40){
                sb.append("XL");
                num=num-40;
            }else{
            sb.append("X");
            num=num-10;
            }
        }
        while(num>=5){
            if(num>=9){
                sb.append("IX");
                num=num-9;
            }else{
            sb.append("V");
            num=num-5;
            }
        }
        while(num>=1){
            if(num>=4){
                sb.append("IV");
                num=num-4;
            }
            else{
            sb.append("I");
            num=num-1;
            }
        }
        
        
        return sb.toString();
    }
}



// Second Solution

class Solution1 {
    public String intToRoman(int num) {
        String ones = "IXCM";
        String fives = "VLD";
        String input = new StringBuilder(Integer.toString(num)).reverse().toString();
        System.out.println(input);
        int index = 0;
        String output = new String();
        
        while(index < input.length()){
           
                if(Character.getNumericValue(input.charAt(index)) == 4){
                   
                    output = String.valueOf(ones.charAt(index))+String.valueOf(fives.charAt(index))+output;
                    System.out.println(output);
                    index++;
                }
                else if(Character.getNumericValue(input.charAt(index))==9){
                    output = String.valueOf(ones.charAt(index)) + String.valueOf(ones.charAt(index+1)) + output;
                    index++;
                }
                else if(Character.getNumericValue(input.charAt(index))==5){
                    output = fives.charAt(index) + output;
                    index++;
                    
                }
                else if(Character.getNumericValue(input.charAt(index))>5){
                    output = fives.charAt(index) + output;
                    int random = Character.getNumericValue(input.charAt(index)) -5;
                    input = input.substring(0, index) + random + input.substring(index + 1);
                    System.out.println(output);
                     for(int i =0; i<Character.getNumericValue(input.charAt(index)); i++){
                            output =  output.substring(0,1)+ones.charAt(index)+output.substring(1);
                         System.out.println(output);
                        }
                    index++;
                    
                }
                else if(Character.getNumericValue(input.charAt(index))<4 && Character.getNumericValue(input.charAt(index))>=0 ){
                    for(int i =0; i <Character.getNumericValue(input.charAt(index)); i++){
                            output =  ones.charAt(index)+output;
                        }
                    index++;
                }
            }    
        
        return output;
    }
}



public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int num = Integer.parseInt(line);
            
            String ret = new Solution().intToRoman(num);
            
            String out = (ret);
            
            System.out.print(out);
        }
    }
}