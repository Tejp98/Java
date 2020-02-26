
import java.util.*;
import java.io.*;
import java.lang.Math;

class Solution {
    public int maxSubArray(int[] nums) {
        int compare1  = nums[0];
        int compare2 = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] > compare1 + nums[i]) {
                compare1 = nums[i];
            } else {
                compare1 += nums[i];
            }
            compare2 = Math.max(compare1, compare2);
        }
        return compare2;
    

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
            
            int ret = new Solution().maxSubArray(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}