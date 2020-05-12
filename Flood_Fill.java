
//Question:



// An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

// Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

// To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

// At the end, return the modified image.

// Example 1:
// Input: 
// image = [[1,1,1],[1,1,0],[1,0,1]]
// sr = 1, sc = 1, newColor = 2
// Output: [[2,2,2],[2,2,0],[2,0,1]]
// Explanation: 
// From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
// by a path of the same color as the starting pixel are colored with the new color.
// Note the bottom corner is not colored 2, because it is not 4-directionally connected
// to the starting pixel.





//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.

import java.util.*;
import java.lang.*;
import java.io.*;





class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // int row = sr;
        // int column = sc;
        int compareWith = image[sr][sc];
        image[sr][sc] = newColor;
        boolean[] check = new boolean[]{true, true, true, true}; 
        
        if(newColor == compareWith){
            int color = newColor;
            newColor = -1;
            coloring(sr, sc, image, newColor, compareWith, "check");
            for(int i =0; i<image.length;i++){
                for(int j=0; j<image[0].length;j++){
                    if(image[i][j]==-1){
                        image[i][j] = color;
                    }
                }
            }
        }
        else{
        coloring(sr, sc, image, newColor, compareWith, "check");
        }
   
        
        return image;
    }
    
    void coloring(int row, int column, int[][] image, int newColor, int compareWith, String check){
	    if(check != "top"){
            if(row>0){
                if(image[row-1][column] == compareWith){
                image[row-1][column] = newColor;
                    
                coloring(row-1, column,image, newColor, compareWith, "bottom");
                }

            }
     }
        if(check != "bottom"){
            if(row<image.length-1){
                if(image[row+1][column] == compareWith){
                image[row+1][column] = newColor;
                    
                coloring(row+1, column,image, newColor, compareWith, "top");

                    }
            }
        }    
        if(check !=  "right"){
            if(column<image[0].length-1){
                if(image[row][column+1] == compareWith){
                image[row][column+1] = newColor;
                    
                coloring(row, column+1,image, newColor, compareWith, "left" );

                }
            }
        }


    if(check != "left"){
		if(column>0) {
			if(image[row][column-1] == compareWith){
			image[row][column-1] = newColor;
             
			coloring(row, column-1,image, newColor, compareWith,"right" );
	        }
	    }
    }

}
    
}