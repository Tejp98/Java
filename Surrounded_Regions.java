// Question : Surrounded Regions


// Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

// A region is captured by flipping all 'O's into 'X's in that surrounded region.

// Example:

// X X X X
// X O O X
// X X O X
// X O X X
// After running your function, the board should be:

// X X X X
// X X X X
// X X X X
// X O X X
// Explanation:

// Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {

    
    public void recursion(char[][] board, int[][] helper, int row, int col){
        
        if(row <= 0 || col <= 0 || board.length-1 <= row || board[0].length-1 <= col){
            return;
        }
        
        if(board[row][col] != 'O'){
            return;
        }
        
        
        helper[row][col] =1;
        
        
            if( col-1>=0  &&   board[row][col-1] == 'O' && helper[row][col-1] != 1){
                helper[row][col-1] = 1;
                recursion(board, helper, row, col-1);
            }
            if(  col+1 <=board[0].length-1 && board[row][col+1] == 'O' && helper[row][col+1] != 1){
                helper[row][col+1] = 1;
                recursion(board, helper, row, col+1);
                
            }
            if(  row+1<=board.length-1 &&  board[row+1][col] == 'O' && helper[row+1][col] != 1 ){
                 helper[row+1][col] = 1;
                recursion(board, helper, row+1, col);
            }

            if(  row-1>=0   && board[row-1][col] == 'O' && helper[row-1][col] != 1 ){
                helper[row-1][col] = 1;
                recursion(board, helper, row-1, col);
            }
        
        
    }
    
    
    public void solve(char[][] board) {
        
        if(board.length>=3 && board[0].length >=3){
            int [][] helper = new int[board.length][board[0].length];
            
            for(int i =0;i<board.length;i++){
                if(board[i][0]=='O' ){
                    helper[i][0] = 1;
                    recursion( board, helper, i, 1);
                }    
            }
            
            for(int i=0;i<board[0].length;i++){
                 if(board[0][i]== 'O'){
                    helper[0][i] = 1;
                    recursion( board, helper, 1, i);
                }
            }
            
            for(int i = board.length-1 ; i>=0 ;i--){
                
                if(board[i][board[0].length-1] =='O' ){
                    helper[i][board[0].length-1] = 1;
                    recursion( board, helper, i, board[0].length-2);
                }
            }
            
            for(int i =board[0].length-1; i>=0;i--){
                if(board[board.length-1][i] == 'O'){
                    helper[board.length-1][i] = 1;
                    recursion( board, helper, board.length-2, i);
                }
            }
            
            for(int i=1;i<board.length-1;i++){
                for(int j=1;j<board[0].length-1;j++){
                    if(board[i][j] == 'O' && helper[i][j] == 0){
                        board[i][j] ='X';
                    }
                    
                }
            }
            
        
            
        }
        
        
    } 
    
    
}