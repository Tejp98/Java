// Question : Course Schedule

// There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

// Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

// Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 

// Example 1:

// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
//              To take course 1 you should have finished course 0. So it is possible.
// Example 2:

// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take. 
//              To take course 1 you should have finished course 0, and to take course 0 you should
//              also have finished course 1. So it is impossible.
 

// Constraints:

// The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
// You may assume that there are no duplicate edges in the input prerequisites.
// 1 <= numCourses <= 10^5




//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;



class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        
        for(int[] x : prerequisites){
            matrix[x[1]][x[0]] =1;
        }
        
        boolean flag = false;
        int[] visited = new int[numCourses];
        for(int i=0;i<matrix.length;i++){
            if(visited[i] == 0 && cycle(i, matrix, visited)){
                return false;
            }
            
        }
        return true;
        
    }
    
    public boolean cycle(int row, int[][] matrix , int[] visited){
        visited[row] =1;
       
            for(int i=0;i<matrix[0].length;i++){
                if(matrix[row][i] ==1){
                    if(visited[i] == 1) {
                    return true;
                    }
                    if(visited[i] == 0 && cycle(i , matrix , visited)){
                        return true;
                    } 
                }
            }
        visited[row] =2;
        return false;
    }
}