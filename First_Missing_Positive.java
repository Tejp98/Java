import java.util.*;
import java.io.*;



class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int spa = 0;  // Smallest Positive Integer in Array
        int index = 0;//Index of the Smallest Positive Integer in Array
        
        
        if(nums.length == 0 || (nums.length == 1 && nums[0] <=0)  || nums[(nums.length-1)] <= 0){
            return 1;
        }
        else{
        for(int i = 0; i< nums.length; i++){
            if(nums[i] > 0){
                spa = nums[i];
                index = i;
                break;
            }
            
        }
        if(spa >= 2){
            return 1;
        }
        else{
            spa = 1;
            while(index < nums.length){
             if(spa == nums[index] ){
                 if( index == ((nums.length)-1) || ((index+1)<nums.length && spa!= nums[index+1]) ) {
                     spa++;
                     index++;
                 }
                 else{
                     index++;
                 }
             }
        
            else{
                return spa;
            }
            
        }
            return ++(nums[(nums.length-1)]);
    }
        }
        
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
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            
            int ret = new Solution().firstMissingPositive(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}