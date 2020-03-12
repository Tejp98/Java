
import java.util.*;
import java.lang.*;


// You are climbing a stair case. It takes n steps to reach to the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Note: Given n will be a positive integer.

// Example 1:

// Input: 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps
// Example 2:

// Input: 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step




class Solution {
   public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] output = new int[n + 1];
        output[1] = 1;
        output[2] = 2;
        for (int i = 3; i <= n; i++) {
            output[i] = output[i - 1] + output[i - 2];
        }
        return output[n];
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            
            int ret = new Solution().climbStairs(n);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}