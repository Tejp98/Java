//  Question : Island Perimeter


// You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

// Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

// The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

// Example:

// Input:
// [[0,1,0,0],
//  [1,1,1,0],
//  [0,1,0,0],
//  [1,1,0,0]]

// Output: 16

// Explanation: The perimeter is the 16 yellow stripes in the image below:


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;




//First Solution:

class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++) {
                if(grid[i][j]==0)
                    continue;
                if(i==0 || grid[i-1][j]==0) perimeter++;
                if(i==n-1 || grid[i+1][j]==0) perimeter++;
                if(j==0 || grid[i][j-1]==0) perimeter++;
                if(j==m-1 || grid[i][j+1]==0) perimeter++;
            }
        return perimeter;
    }
}

//Second Solution:

class Solution {
    int[][] grid;
    public int islandPerimeter(int[][] grids) {
        grid = grids; 
           
        
        
        for(int i=0;i<grid.length;i++){
            
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                   return count( i,j );
                    
                } 
            }
        }
        
        return 0;
    }
    public int count( int row, int col){
        int result =0;
        if(grid[row][col] == 0 || grid[row][col] == 2){
            return 0;
        }
        
        grid[row][col] =2;
        
        
        if(row>0){
            if(grid[row-1][col] == 0){
               result++;  
            }
            else{
                 result += count(row-1 , col);
            }
           
        }
        else if(row==0){
            result++;
        }
      
        
        if(row<(grid.length-1)){
            if( grid[row+1][col] == 0  ){
               result++; 
            }
            else{
                 result += count(row+1 , col);
            }
            
        }
        else if(row == (grid.length-1)){
            result++;
        }

        
        
        
        if(col>0 ){
            if(grid[row][col-1] == 0){
                result++;
            }
            else{
               result += count(row , col-1); 
            }
        }
        else if(col==0){
            result++;
        }
       
        
        
        if(col<(grid[0].length-1)){
            if(  grid[row][col+1] == 0  ){
                result++;
            }
            else{
            result += count(row , col+1);
            }
        }
        else if(col== (grid[0].length-1)){
            result++;
        }
        
        
        
        return result;
    }
}