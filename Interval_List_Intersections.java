
//  Question : Interval List Intersections

// Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

// Return the intersection of these two interval lists.

// (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

 

// Example 1:



// Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
// Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
// Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 

// Notes

// 0 <= A.length < 1000
// 0 <= B.length < 1000
// 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
// NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.




//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;



class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int index1_row =0,index2_row=0;
         
        
        List<int []> answer = new ArrayList<>();
       
        while(index1_row < A.length && index2_row< B.length){
           
            if( A[index1_row][1] < B[index2_row][0]){
               index1_row++;
               
           }
            else if(A[index1_row][0] > B[index2_row][1]){
                index2_row++;
                
            }
            else{
                
                 
               answer.add(new int[]{ Math.max(A[index1_row][0], B[index2_row][0]) , Math.min(A[index1_row][1], B[index2_row][1])});
                
                if(A[index1_row][1] < B[index2_row][1]){
                    index1_row++;
                    
                }
                else if(A[index1_row][1] >= B[index2_row][1]){
                    index2_row++; 
                
            }
                
             
              
        }

        }
        return answer.toArray(new int[answer.size()][]);
    }
}