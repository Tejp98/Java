// Question : Triangle

// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

// For example, given the following triangle

// [
//      [2],
//     [3,4],
//    [6,5,7],
//   [4,1,8,3]
// ]
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

// Note:

// Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.

//Can also be done using array inside of dealing with arraylist for whole problem

import java.util.*;
import java.lang.*;
import java.io.*;



class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        for(int i =triangle.size()-2;i>=0;i--){
            List<Integer> temporary = triangle.get(i);
            for(int j=0;j<triangle.get(i).size();j++){
                temporary.set(j, (temporary.get(j)+Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1) )));
                
            }
            triangle.set(i, temporary);
        }
        
        
        return triangle.get(0).get(0);
    }
}