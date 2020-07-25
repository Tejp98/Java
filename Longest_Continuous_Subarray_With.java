// Question : Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit

// Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.

 

// Example 1:

// Input: nums = [8,2,4,7], limit = 4
// Output: 2 
// Explanation: All subarrays are: 
// [8] with maximum absolute diff |8-8| = 0 <= 4.
// [8,2] with maximum absolute diff |8-2| = 6 > 4. 
// [8,2,4] with maximum absolute diff |8-2| = 6 > 4.
// [8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
// [2] with maximum absolute diff |2-2| = 0 <= 4.
// [2,4] with maximum absolute diff |2-4| = 2 <= 4.
// [2,4,7] with maximum absolute diff |2-7| = 5 > 4.
// [4] with maximum absolute diff |4-4| = 0 <= 4.
// [4,7] with maximum absolute diff |4-7| = 3 <= 4.
// [7] with maximum absolute diff |7-7| = 0 <= 4. 
// Therefore, the size of the longest subarray is 2.
// Example 2:

// Input: nums = [10,1,2,4,7,2], limit = 5
// Output: 4 
// Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
// Example 3:

// Input: nums = [4,2,2,2,4,4,2,2], limit = 0
// Output: 3
 

// Constraints:

// 1 <= nums.length <= 10^5
// 1 <= nums[i] <= 10^9
// 0 <= limit <= 10^9


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int res = 1;
        int count = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);

            if (max - min <= limit) {
                res = Math.max(++count, res);
            } else {
                if (res - 1 > nums.length - i) {
                    break;
                }

                max = nums[i];
                min = nums[i];
                count = 1;
                int j = i;

                while (--j >= 0 && Math.abs(max - nums[j]) <= limit && Math.abs(min - nums[j]) <= limit) {
                    max = Math.max(max, nums[j]);
                    min = Math.min(min, nums[j]);
                    count++;
                }

            }
        }
        return res;
    }
}