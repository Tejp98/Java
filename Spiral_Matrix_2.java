
// Question : Spiral Matrix II

// Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

// Example:

// Input: 3
// Output:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]





//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;



class Solution {
    public int[][] generateMatrix(int n) {
        int [][] grid = new int[n][n];
        int value = 1;
        int sqr = n*n;
        int row1 = 0;
        int col1 = 0;
        int row2 = n-1;
        int col2 = n-1;
        while(value <= sqr){
            for(int j = col1; j <= col2; j++){
                grid[row1][j] = value++;
            }
            for(int i = row1 + 1; i <= row2; i++){
                grid[i][col2] = value++;
            }
            for(int j = col2-1; j >= col1; j--){
                grid[row2][j] = value++;                
            }
            for(int i = row2-1; i >= row1+1; i--){
                grid[i][col1] = value++;
            }
            col1++;
            col2--;
            row1++;            
            row2--;
            
        }            
        return grid;
    }
}