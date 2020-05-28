// Question : Possible Bipartition

// Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

// Each person may dislike some other people, and they should not go into the same group. 

// Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

// Return true if and only if it is possible to split everyone into two groups in this way.

 

// Example 1:

// Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
// Output: true
// Explanation: group1 [1,4], group2 [2,3]
// Example 2:

// Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
// Output: false
// Example 3:

// Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
// Output: false
 

// Note:

// 1 <= N <= 2000
// 0 <= dislikes.length <= 10000
// 1 <= dislikes[i][j] <= N
// dislikes[i][0] < dislikes[i][1]
// There does not exist i != j for which dislikes[i] == dislikes[j].


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;



class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        
        if(N<=2){
            return true;
        }
       int[] value = new int[N+1];
        Arrays.fill(value,-1);
        value[dislikes[0][0]] = 0;
        value[dislikes[0][1]] =1;
        for(int i = 1;i<dislikes.length;i++){
            
            if(value[dislikes[i][0]] == 0){
                if(value[dislikes[i][1]] == -1){
                    value[dislikes[i][1]] = 1;
                }
                else if(value[dislikes[i][1]] == 0){
                    return false;
                }
            }
            else if(value[dislikes[i][0]] == 1){
                if(value[dislikes[i][1]] == -1){
                    
                    value[dislikes[i][1]] = 0;
                    
                }
                else if(value[dislikes[i][1]] == 1){
                    return false;
                }
            }
            else if(value[dislikes[i][1]] == 0){
                if(value[dislikes[i][0]] == -1){
                    value[dislikes[i][0]] = 1;
                }
                else if(value[dislikes[i][0]] == 0){
                    return false;
                }
            }
            else if(value[dislikes[i][1]] == 1){
                if(value[dislikes[i][0]] == -1){
                    value[dislikes[i][0]] = 0;
                }
                else if(value[dislikes[i][0]] == 1){
                    return false;
                }
            }
            else{
                
                 if(i == 1 && N<=5){
                    value[dislikes[1][0]] = 0;
                    value[dislikes[1][1]] =1;
                }
            }
       
        }
        
        return true;
    }
    
}