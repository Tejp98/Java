// Question : Word Search

// Given a 2D board and a word, find if the word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

// Example:

// board =
// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]

// Given word = "ABCCED", return true.
// Given word = "SEE", return true.
// Given word = "ABCB", return false.
 

// Constraints:

// board and word consists only of lowercase and uppercase English letters.
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
// 1 <= word.length <= 10^3

//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.

//First Solution

class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0){
            return true;
        }
        
        for(int i =0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                if(word.charAt(0) == board[i][j]){
                    // System.out.println("Here");
                    // char[][] tem = deepCopyCharMatrix(board);
                    if(check(i, j ,board, word, 0)){
                        return true;
                    }
                    
                }
            }
        }
        // System.out.println("a");
        return false;
    }
    
    public boolean check(int row, int col, char[][ ] board, String word, int indexOfWord){
        // System.out.println(word);
        // System.out.println("row"+row);
        // System.out.println("col"+col);
        
        if(word.length()-1 == indexOfWord){
            if(word.charAt(indexOfWord) == board[row][col]){
                return true;
            }
            // System.out.println("c");
            return false;
        }
        
        if(board[row][col] == word.charAt(indexOfWord)){
            char tem = board[row][col];
            board[row][col] = '$';
            if(row>0 && board[row-1][col] != '$'){
                
                if(check(row-1, col, board, word, indexOfWord+1)){
                    return true;
                }
            }
            if(col>0 && board[row][col-1] != '$'){
                
                if(check(row, col-1, board, word, indexOfWord+1)){
                    return true;
                }
            }
            if(col<(board[0].length-1) &&  board[row][col+1] != '$'){
                
                if(check(row, col+1, board,word, indexOfWord+1)){
                    return true;
                }
            }
            
            if(row<(board.length-1) &&  board[row+1][col] != '$'){
                
                if(check(row+1, col, board,word, indexOfWord+1)){
                    return true;
                }
            }
            board[row][col] = tem;
            // System.out.println("D");
            return false;
        }
        else{
            // System.out.println("e");
            return false;
        }
    }
   
}

//Second Solution



class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0){
            return true;
        }
        
        for(int i =0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                if(word.charAt(0) == board[i][j]){
                    // System.out.println("Here");
                    // char[][] tem = deepCopyCharMatrix(board);
                    if(check(i, j ,board, word)){
                        return true;
                    }
                    
                }
            }
        }
        // System.out.println("a");
        return false;
    }
    
    public boolean check(int row, int col, char[][ ] board, String word){
        // System.out.println(word);
        // System.out.println("row"+row);
        // System.out.println("col"+col);
        
        if(word.length() == 1){
            if(word.charAt(0) == board[row][col]){
                return true;
            }
            // System.out.println("c");
            return false;
        }
        
        if(board[row][col] == word.charAt(0)){
            char tem = board[row][col];
            board[row][col] = '$';
            if(row>0 && board[row-1][col] != '$'){
                
                if(check(row-1, col, board, word.substring(1,word.length()))){
                    return true;
                }
            }
            if(col>0 && board[row][col-1] != '$'){
                
                if(check(row, col-1, board, word.substring(1,word.length()))){
                    return true;
                }
            }
            if(col<(board[0].length-1) &&  board[row][col+1] != '$'){
                
                if(check(row, col+1, board, word.substring(1,word.length()))){
                    return true;
                }
            }
            
            if(row<(board.length-1) &&  board[row+1][col] != '$'){
                
                if(check(row+1, col, board, word.substring(1,word.length()))){
                    return true;
                }
            }
            board[row][col] = tem;
            // System.out.println("D");
            return false;
        }
        else{
            // System.out.println("e");
            return false;
        }
    }
   
}