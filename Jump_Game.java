
// Question:

// Really interesting question.



// Given an array of non-negative integers, you are initially positioned at the first index of the array.

// Each element in the array represents your maximum jump length at that position.

// Your goal is to reach the last index in the minimum number of jumps.

// Example:

// Input: [2,3,1,1,4]
// Output: 2
// Explanation: The minimum number of jumps to reach the last index is 2.
//     Jump 1 step from index 0 to 1, then 3 steps to the last index.
// Note:

// You can assume that you can always reach the last index.





import java.util.*;
import java.lang.*;
import java.io.*;


class Jump_Game {
    public int jump(int[] nums) {
        int index =0;
        int jumps = 0;
        int i=0;
        if(nums.length==1){
            return 0;
        }
        
        while( i < nums.length){
            // int numberOfJumps = nums[i];
            int count =0, previousCount=0;
            // int total=0;
            if(nums[i]>=nums.length-i-1){
                jumps++;
                break;
            }
            else{
                if(nums[i]==1){
                    index++;
                }
                else{
                    for(int j=i+1;j<i+nums[i]+1;j++){
                        if(previousCount<nums[j]+count){
                            previousCount = nums[j]+count;
                            index = j;

                        }
                        count++;
                    }
                }
            }
            i = index;
            jumps++;
        }
        return jumps;
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
            
            int ret = new Jump_Game().jump(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}