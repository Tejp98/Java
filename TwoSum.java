import java.util.*;
import java.io.*;



class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] input = nums.clone();
        Arrays.sort(input);
        int[] output = new int[2];
        int sum = 0,index1=0,index2 = nums.length-1;
        while(index1<index2){
            sum= input[index1]+input[index2];
           
            if(sum == target){
                int j =0;
                for(int i=0;i<nums.length;i++){
                    if(j==2){
                        break;
                    }
                    
                    if(nums[i] == input[index2] || nums[i]  == input[index1]){
                      
                        output[j]= i;
                        j++;
                    
                    }
                }
                     
                break;
            }
            else if(sum>target){
                index2--;
            }
            else{
                index1++;
            }
        }
        return output;
            
        
        
    }
}
class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);
            
            int[] ret = new Solution().twoSum(nums, target);
            
            String out = integerArrayToString(ret);
            
            System.out.print(out);
        }
    }
}