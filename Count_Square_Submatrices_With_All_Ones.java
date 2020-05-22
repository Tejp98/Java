// Question : Count Square Submatrices with All Ones
// Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

// Example 1:

// Input: matrix =
// [
//   [0,1,1,1],
//   [1,1,1,1],
//   [0,1,1,1]
// ]
// Output: 15
// Explanation: 
// There are 10 squares of side 1.
// There are 4 squares of side 2.
// There is  1 square of side 3.
// Total number of squares = 10 + 4 + 1 = 15.
// Example 2:

// Input: matrix = 
// [
//   [1,0,1],
//   [1,1,0],
//   [1,1,0]
// ]
// Output: 7
// Explanation: 
// There are 6 squares of side 1.  
// There is 1 square of side 2. 
// Total number of squares = 6 + 1 = 7.
 

// Constraints:

// 1 <= arr.length <= 300
// 1 <= arr[0].length <= 300



//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;



class Solution {
    public int countSquares(int[][] matrix) {
        int result = matrix[0].length*matrix.length, index =2;
        
        for(int i =0 ; i < matrix.length;i++){
           for(int j=0; j<matrix[i].length;j++){
               if(matrix[i][j] == 0){
                   result--;
               }
           }
       }
        
        while(index<Math.max(matrix[0].length, matrix.length)){
            
            result = result + squares(matrix, index);
            index++;
        }
        return result;
    }
    
    public int squares(int[][] matrix, int side){
        int count =0;
       for(int i =0 ; i <= matrix.length-side;i++){
           for(int j=0; j<=matrix[i].length-side;j++){
               if( matrix[i][j] == 1 && check(matrix,i,j,side)==true){
                   count++;
               }
           }
       }
        
        return count;
    }
    public boolean check(int[][] matrix, int row,int column, int value){
        for(int i =row;i<row+value;i++){
            for(int j =column;j<column+value;j++){
                    if(matrix[i][j] == 0){
                        return false;
                    }        
            }
        }
        return true;
    }
}